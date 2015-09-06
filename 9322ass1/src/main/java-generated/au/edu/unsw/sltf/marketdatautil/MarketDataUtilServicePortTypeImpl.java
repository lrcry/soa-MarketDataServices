package au.edu.unsw.sltf.marketdatautil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import au.edu.unsw.sltf.checkutility.SomeUtil;
import au.edu.unsw.sltf.currency.CurrencyConvertFault_Exception;
import au.edu.unsw.sltf.currency.CurrencyConvertServicePortType;
import au.edu.unsw.sltf.currency.CurrencyConvertServicePortTypeImpl;
import au.edu.unsw.sltf.currency.ExchangeRateRequestMsg;
import au.edu.unsw.sltf.currency.ExchangeRateResponseMsg;

public class MarketDataUtilServicePortTypeImpl implements
		MarketDataUtilServicePortType {

	ObjectFactory obj = new ObjectFactory();
	MarketDataUtilFaultMsg fault = obj.createMarketDataUtilFaultMsg();

	@Override
	public ConvertMarketDataResponseMsg convertMarketData(
			ConvertMarketDataRequestMsg parameters)
			throws MarketDataUtilFaultMsg_Exception {
		// TODO Auto-generated method stub
		// check the correctness of the currency format
		if (!SomeUtil.checkCurrency(parameters.getTargetCurrency())
				|| parameters.getTargetCurrency().trim().toUpperCase()
						.equals("AUD")) {
			fault.setFaultMessage("The target Currency Code is invalid.");
			fault.setFaultType(MarketDataUtilFaultType.INVALID_CURRENCY_CODE);
			throw new MarketDataUtilFaultMsg_Exception(fault.getFaultMessage(),
					fault);
		}

		// check the eventSetId
		String eventSetId = parameters.getEventSetId();
		String targetCurrency = parameters.getTargetCurrency();
		if (!SomeUtil.checkEventSetId(eventSetId)) {
			fault.setFaultMessage("The input EventSetId is invalid.");
			fault.setFaultType(MarketDataUtilFaultType.INVALID_EVENT_SET_ID);
			throw new MarketDataUtilFaultMsg_Exception(fault.getFaultMessage(),
					fault);
		}

		// check whether the eventSetId file has been transformed
		if (SomeUtil.checkFileTransformed(eventSetId, SomeUtil.DEFAULT_CUR)) {
			fault.setFaultMessage("The file already contains converted prices.");
			fault.setFaultType(MarketDataUtilFaultType.INVALID_MARKET_DATA);
			throw new MarketDataUtilFaultMsg_Exception(fault.getFaultMessage(),
					fault);
		}
		// get the exchange rate
		ExchangeRateRequestMsg req = new ExchangeRateRequestMsg();
		ExchangeRateResponseMsg res = new ExchangeRateResponseMsg();
		req.setBaseCurrencyCode(SomeUtil.DEFAULT_CUR);
		req.setTargetCurrencyCode(targetCurrency);
		try {
			CurrencyConvertServicePortType convertServicePortType = new CurrencyConvertServicePortTypeImpl();
			res = convertServicePortType.yahooExchangeRate(req);
		} catch (CurrencyConvertFault_Exception e1) {
			// TODO Auto-generated catch block
			fault.setFaultMessage("The Service is unavailable now.");
			fault.setFaultType(MarketDataUtilFaultType.PROGRAM_ERROR);
			throw new MarketDataUtilFaultMsg_Exception(fault.getFaultMessage(),
					fault);
		}
		double rate = Double.valueOf(res.getRate());
		String privateRepository = System.getProperty("catalina.home")
				+ "/temp/";
		String publicRepository = System.getProperty("catalina.home")
				+ "/webapps/ROOT/";
		String newEventSetId = UUID.randomUUID().toString();
		String oldFileName = privateRepository + eventSetId + "-now.csv";
		String newFileName = privateRepository + newEventSetId + "-now.csv";
		// create input stream
		File oldFile = new File(oldFileName);
		File newFile = new File(newFileName);
		try {
			BufferedReader in = new BufferedReader(new FileReader(oldFile));
			BufferedWriter out = new BufferedWriter(new FileWriter(newFile));
			String line;
			while ((line = in.readLine()) != null) {
				String[] arr = line.split(",");
				if (arr[0].startsWith("#RIC")) {
					out.write(line + "\n");
					continue;
				}
				if (arr.length >= 6 && !"".equals(arr[5])) {
					double value = Double.valueOf(arr[5]) / rate;
					BigDecimal bigV = new BigDecimal(value).setScale(2,
							BigDecimal.ROUND_FLOOR);
					arr[5] = targetCurrency + bigV.toString();
				}
				if (arr.length >= 8 && !"".equals(arr[7])) {
					double value = Double.valueOf(arr[7]) / rate;
					BigDecimal bigV = new BigDecimal(value).setScale(2,
							BigDecimal.ROUND_FLOOR);
					arr[7] = targetCurrency + bigV.toString();
				}
				if (arr.length >= 10 && !"".equals(arr[9])) {
					double value = Double.valueOf(arr[9]) / rate;
					BigDecimal bigV = new BigDecimal(value).setScale(2,
							BigDecimal.ROUND_FLOOR);
					arr[9] = targetCurrency + bigV.toString();
				}
				for (int i = 0; i < 10; i++) {
					if (i < arr.length)
						out.write(arr[i]);
					out.write(",");
				}
				out.write("\n");
			}
			in.close();
			out.close();
			Files.copy(newFile.toPath(), new File(publicRepository
					+ newEventSetId + "-now.csv").toPath(),
					java.nio.file.StandardCopyOption.REPLACE_EXISTING);

		} catch (IOException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		// write the eventsetid into database
		SomeUtil.writeEventSetId(newEventSetId, targetCurrency);
		ConvertMarketDataResponseMsg convertMarketDataResponseMsg = obj
				.createConvertMarketDataResponseMsg();
		convertMarketDataResponseMsg.setEventSetId(newEventSetId);
		return convertMarketDataResponseMsg;
	}

	@Override
	public SummaryMarketDataResponseMsg summaryMarketData(
			SummaryMarketDataRequestMsg parameters)
			throws MarketDataUtilFaultMsg_Exception {
		// TODO Auto-generated method stub

		String eventSetId = parameters.getEventSetId();
		// check the eventSetID valid or not
		if (!SomeUtil.checkEventSetId(eventSetId)) {
			fault.setFaultMessage("The input EventSetId is invalid.");
			fault.setFaultType(MarketDataUtilFaultType.INVALID_EVENT_SET_ID);
			throw new MarketDataUtilFaultMsg_Exception(fault.getFaultMessage(),
					fault);
		}
		
		// construct the responseMsg
		String currency = SomeUtil.getCurrencyCode(eventSetId);
		String sec = "DUMM";
		String startDate = "01-JAN-2222";
		String endDate = "01-JAN-1970";
		SummaryMarketDataResponseMsg res = new SummaryMarketDataResponseMsg();
		try {
			DateFormat format = new SimpleDateFormat("dd-MMM-yyyy",
					Locale.ENGLISH);
			Date dateStart = format.parse(startDate);
			Date dateEnd = format.parse(endDate);
			int numberOfLines = 0;

			String privateRepository = System.getProperty("catalina.home")
					+ "/temp/";
			String filePath = privateRepository + eventSetId + "-now.csv";

			BufferedReader in = new BufferedReader(new FileReader(filePath));
			String line = "";
			while ((line = in.readLine()) != null) {
				String[] str = line.split(",");
				if (!str[0].matches("#RIC")) {
					if (str.length >= 1) {
						sec = str[0];
					}
					if (str.length >= 2) {
						Date date = format.parse(str[1]);
						if (date.before(dateStart))
							dateStart = date;
						if (date.after(dateEnd))
							dateEnd = date;
					}
					numberOfLines++;
				}
			}
			DateFormat format2 = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
			startDate = format2.format(dateStart).toString();
			endDate = format2.format(dateEnd).toString();
			res.setEventSetId(eventSetId);
			res.setSec(sec);
			res.setStartDate(startDate);
			res.setEndDate(endDate);
			res.setCurrencyCode(currency);
			res.setNumberOfLines(numberOfLines);
			
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			fault.setFaultMessage("The file format is not correct.");
			fault.setFaultType(MarketDataUtilFaultType.INVALID_MARKET_DATA);
			throw new MarketDataUtilFaultMsg_Exception(fault.getFaultMessage(),
					fault);
		}
		return res;
	}

}
