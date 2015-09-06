package au.edu.unsw.sltf.currency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;

import javax.jws.WebService;

import au.edu.unsw.sltf.checkutility.SomeUtil;



@WebService(endpointInterface = "au.edu.unsw.sltf.currency.CurrencyConvertServicePortType")
public class CurrencyConvertServicePortTypeImpl implements CurrencyConvertServicePortType{

	ObjectFactory obj = new ObjectFactory();

	@Override
	public ExchangeRateResponseMsg yahooExchangeRate(
			ExchangeRateRequestMsg parameters)
			throws CurrencyConvertFault_Exception {
		// TODO Auto-generated method stub
		
		String baseCurrencyCode = parameters.getBaseCurrencyCode();
		String targetCurrencyCode = parameters.getTargetCurrencyCode();
//		Set<Currency> set = Currency.getAvailableCurrencies();
		if (!SomeUtil.checkCurrency(baseCurrencyCode) || !SomeUtil.checkCurrency(targetCurrencyCode)) {
			CurrencyConvertFault fault = obj.createCurrencyConvertFault();
			fault.setFaultMessage("The input Currency Code is invalid.");
			fault.setFaultType(CurrencyConvertFaultType.INVALID_CURRENCY_CODE);
			CurrencyConvertFault_Exception faultException = new CurrencyConvertFault_Exception(fault.getFaultMessage(), fault);
			throw faultException;
		}
		URL url;
		ExchangeRateResponseMsg res = obj.createExchangeRateResponseMsg();
		try {
			url = new URL("http://finance.yahoo.com/d/quotes.csv?e=.csv&f=sl1d1t1&s="+baseCurrencyCode + targetCurrencyCode +"=X");
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String inputLine;
			//begin to catch certain lines
			inputLine = in.readLine();
			String[] result = inputLine.split(",");
			System.out.println(inputLine);
			String rate = result[1];
			String asAt = SomeUtil.transformDate(result[2]);
			res.setRate(rate);
			res.setAsAt(asAt);
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			CurrencyConvertFault fault = obj.createCurrencyConvertFault();
			fault.setFaultMessage("The Yahoo Service is not available now.");
			fault.setFaultType(CurrencyConvertFaultType.INVALID_SERVICE_CODE);
			CurrencyConvertFault_Exception faultException = new CurrencyConvertFault_Exception(fault.getFaultMessage(), fault);
			throw faultException;
		}
		return res;
	}

}
