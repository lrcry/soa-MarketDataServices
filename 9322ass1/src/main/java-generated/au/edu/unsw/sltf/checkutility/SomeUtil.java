package au.edu.unsw.sltf.checkutility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.opencsv.CSVReader;

public class SomeUtil {
	public static String DEFAULT_CUR = "AUD";
	static String[] viaLocales = { "JPY", "CNY", "SDG", "RON", "MKD", "MXN",
			"CAD", "ZAR", "AUD", "NOK", "ILS", "ISK", "SYP", "LYD", "UYU",
			"YER", "CSD", "EEK", "THB", "IDR", "LBP", "AED", "BOB", "QAR",
			"BHD", "HNL", "HRK", "COP", "ALL", "DKK", "MYR", "SEK", "RSD",
			"BGN", "DOP", "KRW", "LVL", "VEF", "CZK", "TND", "KWD", "VND",
			"JOD", "NZD", "PAB", "CLP", "PEN", "GBP", "DZD", "CHF", "RUB",
			"UAH", "ARS", "SAR", "EGP", "INR", "PYG", "TWD", "TRY", "BAM",
			"OMR", "SGD", "MAD", "BYR", "NIO", "HKD", "LTL", "SKK", "GTQ",
			"BRL", "EUR", "HUF", "IQD", "CRC", "PHP", "SVC", "PLN", "USD" };

	public static String eventSetIdFile = System.getProperty("catalina.home")
			+ "/temp/" + "eventSetIdFile.txt";
	public static String privateRepository = System
			.getProperty("catalina.home") + "/temp/";
	public static String publicRepository = System.getProperty("catalina.home")
			+ "/webapps/ROOT/";

	public static boolean checkCurrency(String currencyCode) {
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < viaLocales.length; i++) {
			set.add(viaLocales[i]);
		}
		if (set.contains(currencyCode.trim().toUpperCase()))
			return true;
		else
			return false;
	}

	public static String transformDate(String asAt) throws ParseException {
		asAt = asAt.replaceAll("\"", "");
		DateFormat format1 = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
		DateFormat format2 = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
		Date date = format1.parse(asAt);
		asAt = format2.format(date).toString();
		return asAt;
	}

	public static boolean checkEventSetId(String eventSetId) {
		BufferedReader in;
		boolean ifExist = false;
		try {
			in = new BufferedReader(new FileReader(new File(eventSetIdFile)));
			String line;
			while ((line = in.readLine()) != null) {
				String[] str = line.split(",");
				if (str[0].equals(eventSetId))
					ifExist = true;
			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ifExist;
	}

	public static String getIPAddress() {
		String ipAddress = new String();
		try {
			ipAddress = InetAddress.getLocalHost().getHostAddress();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ipAddress;
	}

	public static void writeEventSetId(String eventSetId, String currency) {
		File file = new File(eventSetIdFile);
		BufferedWriter out;
		try {
			out = new BufferedWriter(new FileWriter(file, true));
			out.write(eventSetId + "," + currency + "\n");
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(eventSetId);
	}

	public static boolean checkFileTransformed(String eventSetId,
			String currency) {
		BufferedReader in;
		boolean ifTrans = false;
		try {
			in = new BufferedReader(new FileReader(new File(eventSetIdFile)));
			String line;
			while ((line = in.readLine()) != null) {
				String[] str = line.split(",");
				if (str[0].equals(eventSetId) && !str[1].equals(currency)) {
					ifTrans = true;
				}
			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ifTrans;
	}

	public static String getCurrencyCode(String eventSetId) {
		BufferedReader in;
		String currencyCode = "";
		try {
			in = new BufferedReader(new FileReader(new File(eventSetIdFile)));
			String line;
			while ((line = in.readLine()) != null) {
				String[] str = line.split(",");
				if (str[0].equals(eventSetId) && str.length >= 2
						&& !"".equals(str[1])) {
					currencyCode = str[1];
				}
			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currencyCode;
	}

	public static void createXMLFileByEventSetId(String eventSetId) throws Exception {
		BufferedReader csvReader;
		File csvFile = new File(privateRepository + eventSetId + "-now.csv");
		File xmlFile = new File(privateRepository + eventSetId + "-now.xml");
		DocumentBuilderFactory domFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder domBuilder;
		domBuilder = domFactory.newDocumentBuilder();
		Document doc = domBuilder.newDocument();

		// Root Element
		Element rootElement = doc.createElement("MarketDatas");
		doc.appendChild(rootElement);
		// read the csv file
		csvReader = new BufferedReader(new FileReader(csvFile));

		// Now using the OpenCSV
		CSVReader reader = new CSVReader(csvReader);
		String[] nextLine;
		int line = 0;
		List<String> headers = new ArrayList<String>(11);

		while ((nextLine = reader.readNext()) != null) {
			if (line == 0) {// Header
				for (String col : nextLine) {

					col = col.replace("#", "").replace("[G]", "")
							.replace(" ", "");

					headers.add(col);
				}
			} else {// Data
				Element rowElement = doc.createElement("MarketData");
				rootElement.appendChild(rowElement);

				int col = 0;
				for (String value : nextLine) {
					String header = headers.get(col);

					System.out.println(value);
					Element curElement = doc.createElement(header);
					curElement.setTextContent(value.trim());
					rowElement.appendChild(curElement);

					col++;
				}
			}
			line++;
		}
		// begin input
		FileWriter writer = new FileWriter(xmlFile, false);

		TransformerFactory tranFactory = TransformerFactory.newInstance();
		Transformer aTransformer = tranFactory.newTransformer();
		aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
		aTransformer.setOutputProperty(OutputKeys.METHOD, "xml");
		aTransformer.setOutputProperty(
				"{http://xml.apache.org/xslt}indent-amount", "4");

		Source src = new DOMSource(doc);
		Result result = new StreamResult(writer);
		aTransformer.transform(src, result);

		writer.flush();
		writer.close();
		Files.copy(xmlFile.toPath(), new File(publicRepository + eventSetId
				+ "-now.xml").toPath(),
				java.nio.file.StandardCopyOption.REPLACE_EXISTING);

	}

	public static void createHTMLFileByEventSetId(String eventSetId)
			throws Exception {
		BufferedReader in;
		BufferedWriter out;
		File csvFile = new File(privateRepository + eventSetId + "-now.csv");
		File htmlFile = new File(privateRepository + eventSetId + "-now.html");

		in = new BufferedReader(new FileReader(csvFile));
		out = new BufferedWriter(new FileWriter(htmlFile, false));
		String nextline = "";
		String line = "<html>\n<table border='1'>\n<tr>\n<td>";
		while ((nextline = in.readLine()) != null) {
			out.write(line);
			line = nextline.replace(",", "</td><td>")
					+ "</td>\n</tr>\n<tr>\n<td>";
			line = line.replace("<td></td>", "<td>&nbsp;</td>");
		}
		line = line.replace("\n<tr>\n<td>", "").replace("<td></td>",
				"<td>&nbsp;</td>");
		out.write(line);
		out.write("</td>\n</tr>\n</table>\n</html>");
		in.close();
		out.close();
		Files.copy(htmlFile.toPath(), new File(publicRepository + eventSetId
				+ "-now.html").toPath(),
				java.nio.file.StandardCopyOption.REPLACE_EXISTING);

	}
}
