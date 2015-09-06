package au.edu.unsw.sltf.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import javax.jws.WebService;

import au.edu.unsw.sltf.checkutility.SomeUtil;

@WebService(endpointInterface = "au.edu.unsw.sltf.services.ImportDownloadServicesPortType")
public class ImportDownloadServicesPortTypeImpl implements
		ImportDownloadServicesPortType {
	ObjectFactory obj = new ObjectFactory();
	ImportDownloadFault fault = obj.createImportDownloadFault();

	@Override
	public String downloadFile(String eventSetId, String fileType)
			throws ImportDownloadFault_Exception {
		// TODO Auto-generated method stub
		if (!fileType.toUpperCase().trim().matches("^(CSV|XML|HTML)$")) {

			fault.setFaultMessage("The input fileType is not one of the expected values.");
			fault.setFaultType(ImportDownloadFaultType.INVALID_FILE_TYPE);
			ImportDownloadFault_Exception faultException = new ImportDownloadFault_Exception(
					fault.getFaultMessage(), fault);
			throw faultException;
		}

		boolean ifExist = SomeUtil.checkEventSetId(eventSetId);
		if (!ifExist) {
			fault.setFaultMessage("The input eventSetId is not known on the server repository.");
			fault.setFaultType(ImportDownloadFaultType.INVALID_EVENT_SET_ID);
			ImportDownloadFault_Exception faultException = new ImportDownloadFault_Exception(
					fault.getFaultMessage(), fault);
			throw faultException;
		}

		String ipAddress = SomeUtil.getIPAddress();
		String fileAddress = ipAddress + ":8080/" + eventSetId + "-now."
				+ fileType.toLowerCase();
		try {
			if (fileType.trim().toUpperCase().equals("XML")) {
				SomeUtil.createXMLFileByEventSetId(eventSetId);
			} else if (fileType.trim().toUpperCase().equals("HTML")) {
				SomeUtil.createHTMLFileByEventSetId(eventSetId);
			}
		} catch (Exception e) {
			fault.setFaultMessage("Server got some problem now.");
			fault.setFaultType(ImportDownloadFaultType.PROGRAM_ERROR);
			ImportDownloadFault_Exception faultException = new ImportDownloadFault_Exception(
					fault.getFaultMessage(), fault);
			throw faultException;
		}
		return fileAddress;
	}

	@Override
	public String importMarketData(String sec, String startDate,
			String endDate, String dataSourceURL)
			throws ImportDownloadFault_Exception {
		// TODO Auto-generated method stub

		String eventSetId = new String();
		try {
			// check the validness of the date
			DateFormat format = new SimpleDateFormat("dd-MMM-yyyy",
					Locale.ENGLISH);
			DateFormat format2 = new SimpleDateFormat("dd-MM-yyyy");
			Date start_Date = format2.parse(startDate);
			Date end_Date = format2.parse(endDate);
			if (start_Date.after(end_Date)) {
				fault.setFaultMessage("The end date must be before the start date.");
				fault.setFaultType(ImportDownloadFaultType.INVALID_DATES);
				ImportDownloadFault_Exception faultException = new ImportDownloadFault_Exception(
						fault.getFaultMessage(), fault);
				throw faultException;
			}
			// check the format of url
			if (!dataSourceURL.toLowerCase().matches("http[s]?://(.*)"))
				throw new MalformedURLException();
			// check the format of SEC code
			if (!sec.matches("[a-zA-z]{3}[a-zA-Z]?")) {
				fault.setFaultMessage("The SEC code should be in 3-4 alphabets characters.");
				fault.setFaultType(ImportDownloadFaultType.INVALID_SEC_CODE);
				ImportDownloadFault_Exception faultException = new ImportDownloadFault_Exception(
						fault.getFaultMessage(), fault);
				throw faultException;
			}
			URL url = new URL(dataSourceURL);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					url.openStream()));
			// generate the file name, in certain directory
			String privateRepository = System.getProperty("catalina.home")
					+ "/temp/";
			String publicRepository = System.getProperty("catalina.home")
					+ "/webapps/ROOT/";
			eventSetId = UUID.randomUUID().toString();
			String fileName = eventSetId + "-now.csv";
			File file = new File(privateRepository + fileName);

			BufferedWriter out = new BufferedWriter(new FileWriter(file));

			String inputLine;
			// begin to catch certain lines
			boolean secExist = false;
			boolean ifWrite = false;
			while ((inputLine = in.readLine()) != null) {
				String[] arr = inputLine.split(",");
				if (arr[0].startsWith("#RIC"))
					out.write(inputLine + "\n");
				if (arr[0].equals(sec)) {
					secExist = true;
					// this date
					Date date = format.parse(arr[1]);

					if (date.compareTo(start_Date) >= 0
							&& date.compareTo(end_Date) <= 0) {
						ifWrite = true;
						out.write(inputLine + "\n");
					}
				}
			}
			in.close();
			out.close();
			// check sec exists in the corresponding file
			if (!secExist) {
				fault.setFaultMessage("The SEC code doesn't exist in the corresponding file.");
				fault.setFaultType(ImportDownloadFaultType.INVALID_SEC_CODE);
				ImportDownloadFault_Exception faultException = new ImportDownloadFault_Exception(
						fault.getFaultMessage(), fault);
				throw faultException;
			}

			if (!ifWrite) {
				fault.setFaultMessage("The output Market file is empty.");
				fault.setFaultType(ImportDownloadFaultType.PROGRAM_ERROR);
				ImportDownloadFault_Exception faultException = new ImportDownloadFault_Exception(
						fault.getFaultMessage(), fault);
				throw faultException;
			}
			in.close();
			out.close();
			Files.copy(file.toPath(),
					new File(publicRepository + fileName).toPath(),
					java.nio.file.StandardCopyOption.REPLACE_EXISTING);

			// save the eventsetid in a file
			SomeUtil.writeEventSetId(eventSetId, "AUD");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			fault.setFaultMessage("The input URL is in the wrong format.");
			fault.setFaultType(ImportDownloadFaultType.INVALID_URL);
			ImportDownloadFault_Exception faultException = new ImportDownloadFault_Exception(
					fault.getFaultMessage(), fault);
			throw faultException;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			fault.setFaultMessage("The input URL is not reachable.");
			fault.setFaultType(ImportDownloadFaultType.INVALID_URL);
			ImportDownloadFault_Exception faultException = new ImportDownloadFault_Exception(
					fault.getFaultMessage(), fault);
			throw faultException;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			fault.setFaultMessage("The data format should be dd-MM-yyyy.");
			fault.setFaultType(ImportDownloadFaultType.INVALID_DATES);
			ImportDownloadFault_Exception faultException = new ImportDownloadFault_Exception(
					fault.getFaultMessage(), fault);
			throw faultException;
		}

		return eventSetId;
	}

}
