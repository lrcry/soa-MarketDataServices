package au.edu.unsw.sltf.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import au.edu.unsw.sltf.currency.CurrencyConvertFaultException;
import au.edu.unsw.sltf.currency.CurrencyConvertServicePortType;
import au.edu.unsw.sltf.currency.ExchangeRateRequestMsg;
import au.edu.unsw.sltf.currency.ExchangeRateResponseMsg;
import au.edu.unsw.sltf.marketdatautil.ConvertMarketDataRequestMsg;
import au.edu.unsw.sltf.marketdatautil.ConvertMarketDataResponseMsg;
import au.edu.unsw.sltf.marketdatautil.MarketDataUtilFaultMsgException;
import au.edu.unsw.sltf.marketdatautil.MarketDataUtilServicePortType;
import au.edu.unsw.sltf.marketdatautil.SummaryMarketDataRequestMsg;
import au.edu.unsw.sltf.marketdatautil.SummaryMarketDataResponseMsg;
import au.edu.unsw.sltf.services.ImportDownloadServicesPortType;

@Controller
public class MarketDataServicesController {
	@Autowired
	private ImportDownloadServicesPortType importDownloadServicesPortType;
	
	@Autowired
	private CurrencyConvertServicePortType currencyConvertServicePortType;
	
	@Autowired
	private MarketDataUtilServicePortType marketDataUtilServicePortType;

	@RequestMapping("/importMarketData")
	public String processImportMarketData(ModelMap model,
			@RequestParam("sec") String sec,
			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate,
			@RequestParam("dataSourceURL") String dataSourceURL) {

		// Call the web service
		try {
			String response = importDownloadServicesPortType.importMarketData(
					sec, startDate, endDate, dataSourceURL);

			//response contains eventsetid only
			model.addAttribute("eventSetId", response);
		} catch (au.edu.unsw.sltf.services.ImportDownloadFaultException e) {
			String errorMessage = e.getMessage();
			String errCode = e.getFaultInfo().getFaultType();
			System.out.println(errCode);
			model.addAttribute("errorMessage", errorMessage);
			model.addAttribute("errCode", errCode);
			return "errorPage";
		}

		// View we are returning to, in this case processImportMarketData.jsp
		return "processImportMarketData";
	}
	
	@RequestMapping("/downloadFile")
	public String processDownloadFile(ModelMap model,
			@RequestParam("eventSetId") String eventSetId,
			@RequestParam("fileType") String fileType) {
		try {
			System.out.println(eventSetId + " " + fileType);
			
			String response = importDownloadServicesPortType.downloadFile(eventSetId, fileType);
			
			model.addAttribute("dataURL", response);
		} catch (au.edu.unsw.sltf.services.ImportDownloadFaultException e) {
			String errorMessage = e.getMessage();
			String errCode = e.getFaultInfo().getFaultType();
			System.out.println(errCode);
			model.addAttribute("errorMessage", errorMessage);
			model.addAttribute("errCode", errCode);
			return "errorPage";
		}
		return "processDownloadFile";
	}
	
	@RequestMapping("/yahooExchangeRate")
	public String processYahooExchangeRate(ModelMap model,
			@RequestParam("baseCurrencyCode") String baseCurrencyCode,
			@RequestParam("targetCurrencyCode") String targetCurrencyCode) {
		//set the request
		ExchangeRateRequestMsg request = new au.edu.unsw.sltf.currency.ObjectFactory().createExchangeRateRequestMsg();
		request.setBaseCurrencyCode(baseCurrencyCode);
		request.setTargetCurrencyCode(targetCurrencyCode);
		
		//call the service
		try {
			ExchangeRateResponseMsg response = currencyConvertServicePortType.yahooExchangeRate(request);
			String rate = response.getRate();
			String asAt = response.getAsAt();
			
			model.addAttribute("rate", rate);
			model.addAttribute("asAt", asAt);
		} catch (CurrencyConvertFaultException e) {
			String errorMessage = e.getMessage();
			String errCode = e.getFaultInfo().getFaultType();
			System.out.println(errCode);
			model.addAttribute("errorMessage", errorMessage);
			model.addAttribute("errCode", errCode);
			return "errorPage";
		}
		return "processYahooExchangeRate";
	}
	
	@RequestMapping("/convertMarketData")
	public String processConvertMarketData(ModelMap model,
			@RequestParam("eventSetId") String eventSetId,
			@RequestParam("targetCurrency") String targetCurrency) {
		//set the request
		ConvertMarketDataRequestMsg request = new au.edu.unsw.sltf.marketdatautil.ObjectFactory().createConvertMarketDataRequestMsg();
		request.setEventSetId(eventSetId);
		request.setTargetCurrency(targetCurrency);
		
		//call the service
		try {
			ConvertMarketDataResponseMsg response = marketDataUtilServicePortType.convertMarketData(request);
			String eventSetIdRes = response.getEventSetId();
			
			model.addAttribute("eventSetId", eventSetIdRes);
		} catch (MarketDataUtilFaultMsgException e) {
			String errorMessage = e.getMessage();
			String errCode = e.getFaultInfo().getFaultType();
			System.out.println(errCode);
			model.addAttribute("errorMessage", errorMessage);
			model.addAttribute("errCode", errCode);
			return "errorPage";
		}
		return "processConvertMarketData";
	}
	
	@RequestMapping("/summaryMarketData")
	public String processSummaryMarketData(ModelMap model,
			@RequestParam("eventSetId") String eventSetId) {
		//set the request
		SummaryMarketDataRequestMsg request = new au.edu.unsw.sltf.marketdatautil.ObjectFactory().createSummaryMarketDataRequestMsg();
		request.setEventSetId(eventSetId);
		
		//call the service
		try {
			SummaryMarketDataResponseMsg response = marketDataUtilServicePortType.summaryMarketData(request);
			String sec = response.getSec();
			String startDate = response.getStartDate();
			String endDate = response.getEndDate();
			String currencyCode = response.getCurrencyCode();
			String numberOfLines = Integer.toString(response.getNumberOfLines());
			
			model.addAttribute("eventSetId", eventSetId);
			model.addAttribute("sec", sec);
			model.addAttribute("startDate", startDate);
			model.addAttribute("endDate", endDate);
			model.addAttribute("currencyCode", currencyCode);
			model.addAttribute("numberOfLines", numberOfLines);
		} catch (MarketDataUtilFaultMsgException e) {
			String errorMessage = e.getMessage();
			String errCode = e.getFaultInfo().getFaultType();
			System.out.println(errCode);
			model.addAttribute("errorMessage", errorMessage);
			model.addAttribute("errCode", errCode);
			return "errorPage";
		}
		return "processSummaryMarketData";
	}
}
