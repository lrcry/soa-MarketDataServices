package au.edu.unsw.sltf.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;
import java.text.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.cxf.transport.http.HttpServletRequestSnapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import au.edu.unsw.sltf.beans.DownloadFileBean;
import au.edu.unsw.sltf.beans.ErrorBean;
import au.edu.unsw.sltf.beans.SummaryMarketDataBean;
import au.edu.unsw.sltf.currency.CurrencyConvertServicePortType;
import au.edu.unsw.sltf.marketdatautil.ConvertMarketDataRequestMsg;
import au.edu.unsw.sltf.marketdatautil.ConvertMarketDataResponseMsg;
import au.edu.unsw.sltf.marketdatautil.MarketDataUtilFaultMsgException;
import au.edu.unsw.sltf.marketdatautil.MarketDataUtilServicePortType;
import au.edu.unsw.sltf.marketdatautil.SummaryMarketDataRequestMsg;
import au.edu.unsw.sltf.marketdatautil.SummaryMarketDataResponseMsg;
import au.edu.unsw.sltf.services.ImportDownloadServicesPortType;

@Controller
@Scope("session")
public class MarketDataClientAppController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1081818633475115654L;
	private static final DateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private static final DateFormat serviceDateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	@Autowired
	private ImportDownloadServicesPortType importDownloadServicesPortType;
	
	@Autowired
	private CurrencyConvertServicePortType currencyConvertServicePortType;
	
	@Autowired
	private MarketDataUtilServicePortType marketDataUtilServicePortType;
	
	
	@RequestMapping(value="/importConvertDownload")
	@ResponseBody
	public Object processImportConvertDownload(
			@RequestParam("sec") String sec,
			@RequestParam("startDate") String startDate,
			@RequestParam(value = "endDate", required = true) String endDate,
			@RequestParam(value = "dataSourceURL", required = true) String dataSourceURL,
			@RequestParam(value = "targetCurrency", required = true) String targetCurrency,
			@RequestParam(value = "fileType", required = true) String fileType,
			HttpServletRequest request
			) {
		//set the request
		DownloadFileBean response = new DownloadFileBean();
		
		HttpSession session = request.getSession();

		ArrayList<String> list = new ArrayList<String>();
		if (session.getAttribute("idlist") != null)
			list = (ArrayList<String>)(session.getAttribute("idlist"));
		try {
			startDate = getConvertedDateString(startDate);
			endDate = getConvertedDateString(endDate);
						
			//call the import service
			String eventSetId = importDownloadServicesPortType.importMarketData(
					sec, startDate, endDate, dataSourceURL);
			
			//call the convert service
			ConvertMarketDataRequestMsg convertRequest = new au.edu.unsw.sltf.marketdatautil.ObjectFactory().createConvertMarketDataRequestMsg();
			convertRequest.setEventSetId(eventSetId);
			convertRequest.setTargetCurrency(targetCurrency);
			
			ConvertMarketDataResponseMsg convertResponse = marketDataUtilServicePortType.convertMarketData(convertRequest);
			String eventSetIdRes = convertResponse.getEventSetId();
			
			// call the download service
			String dataURL = importDownloadServicesPortType.downloadFile(eventSetIdRes, fileType);
			//response contains eventsetid only
			list.add(eventSetId);
			list.add(eventSetIdRes);
			System.out.println(list);
			session.setAttribute("idlist", list);
			response.setDataURL(dataURL);
			response.setIdList(list);
		} catch (au.edu.unsw.sltf.services.ImportDownloadFaultException e) {
			String errCode = e.getFaultInfo().getFaultType();
			String errorMessage = e.getMessage();
			ErrorBean error = new ErrorBean();
			error.setErrCode(errCode);
			error.setErrorMessage(errorMessage);
			return error;
		} catch (MarketDataUtilFaultMsgException e) {
			String errCode = e.getFaultInfo().getFaultType();
			String errorMessage = e.getMessage();
			ErrorBean error = new ErrorBean();
			error.setErrCode(errCode);
			error.setErrorMessage(errorMessage);
			return error;
		} catch (ParseException e) {
			String errCode = "InvalidDate";
			String errorMessage = e.getMessage();
			ErrorBean error = new ErrorBean();
			error.setErrCode(errCode);
			error.setErrorMessage(errorMessage);
			return error;
		}
		
		
		return response;
	}
	
	@ResponseBody
	@RequestMapping( "/importSummary" )
	public Object processImportSummary(
			@RequestParam("sec") String sec,
			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate,
			@RequestParam("dataSourceURL") String dataSourceURL,
			HttpServletRequest request) {
		SummaryMarketDataBean response = new SummaryMarketDataBean();
		HttpSession session = request.getSession();
		ArrayList<String> list = new ArrayList<String>();
		if (session.getAttribute("idlist") != null)
			list = (ArrayList<String>)session.getAttribute("idlist");
		try {
			startDate = getConvertedDateString(startDate);
			endDate = getConvertedDateString(endDate);
			
			System.out.println("startdate: " + startDate);
			System.out.println("enddate: " + endDate);
			
			String eventSetId = importDownloadServicesPortType.importMarketData(
					sec, startDate, endDate, dataSourceURL);
			
			SummaryMarketDataRequestMsg summaryRequest = new au.edu.unsw.sltf.marketdatautil.ObjectFactory().createSummaryMarketDataRequestMsg();
			summaryRequest.setEventSetId(eventSetId);
			
			SummaryMarketDataResponseMsg summaryResponse = marketDataUtilServicePortType.summaryMarketData(summaryRequest);
			sec = summaryResponse.getSec();
			startDate = summaryResponse.getStartDate();
			endDate = summaryResponse.getEndDate();
			String currencyCode = summaryResponse.getCurrencyCode();
			String numberOfLines = Integer.toString(summaryResponse.getNumberOfLines());
			
			response.setEventSetId(eventSetId);
			response.setSec(sec);
			response.setStartDate(startDate);
			response.setEndDate(endDate);
			response.setCurrencyCode(currencyCode);
			response.setNumberOfLines(numberOfLines);
			
			System.out.println("nubmeroflines: " + numberOfLines);
			
			list.add(eventSetId);
			session.setAttribute("idlist", list);
			response.setIdList(list);
			
			
		} catch (au.edu.unsw.sltf.services.ImportDownloadFaultException e){
			String errCode = e.getFaultInfo().getFaultType();
			String errorMessage = e.getMessage();
			ErrorBean error = new ErrorBean();
			error.setErrCode(errCode);
			error.setErrorMessage(errorMessage);
			return error;
		} catch (MarketDataUtilFaultMsgException e) {
			String errCode = e.getFaultInfo().getFaultType();
			String errorMessage = e.getMessage();
			ErrorBean error = new ErrorBean();
			error.setErrCode(errCode);
			error.setErrorMessage(errorMessage);
			return error;
		} catch (ParseException e) {
			String errCode = "InvalidDate";
			String errorMessage = e.getMessage();
			ErrorBean error = new ErrorBean();
			error.setErrCode(errCode);
			error.setErrorMessage(errorMessage);
			return error;
		}
		return response;
	}
	
	@ResponseBody
	@RequestMapping( "/convertSummary" )
	public Object processConvertSummary(
			@RequestParam("eventSetId") String eventSetId,
			@RequestParam("targetCurrency") String targetCurrency,
			HttpServletRequest request) {
		SummaryMarketDataBean response = new SummaryMarketDataBean();
		
		HttpSession session = request.getSession();
		ArrayList<String> list = new ArrayList<String>();
		if (session.getAttribute("idlist") != null)
			list = (ArrayList<String>)session.getAttribute("idlist");

		try {
			ConvertMarketDataRequestMsg convertRequest = new au.edu.unsw.sltf.marketdatautil.ObjectFactory().createConvertMarketDataRequestMsg();
			convertRequest.setEventSetId(eventSetId);
			convertRequest.setTargetCurrency(targetCurrency);
			
			ConvertMarketDataResponseMsg convertResponse = marketDataUtilServicePortType.convertMarketData(convertRequest);
			String eventSetIdRes = convertResponse.getEventSetId();
			
			SummaryMarketDataRequestMsg summaryRequest = new au.edu.unsw.sltf.marketdatautil.ObjectFactory().createSummaryMarketDataRequestMsg();
			summaryRequest.setEventSetId(eventSetIdRes);
			
			SummaryMarketDataResponseMsg summaryResponse = marketDataUtilServicePortType.summaryMarketData(summaryRequest);
			String sec = summaryResponse.getSec();
			String startDate = summaryResponse.getStartDate();
			String endDate = summaryResponse.getEndDate();
			String currencyCode = summaryResponse.getCurrencyCode();
			String numberOfLines = Integer.toString(summaryResponse.getNumberOfLines());
			
			response.setEventSetId(eventSetIdRes);
			response.setSec(sec);
			response.setStartDate(startDate);
			response.setEndDate(endDate);
			response.setCurrencyCode(currencyCode);
			response.setNumberOfLines(numberOfLines);
			
			list.add(eventSetId);
			list.add(eventSetIdRes);
			session.setAttribute("idlist", list);
			response.setIdList(list);
			
			
		} catch (MarketDataUtilFaultMsgException e) {
			String errCode = e.getFaultInfo().getFaultType();
			String errorMessage = e.getMessage();
			ErrorBean error = new ErrorBean();
			error.setErrCode(errCode);
			error.setErrorMessage(errorMessage);
			return error;
		}
		return response;
	}
	
	/**
	 * Get current event set ID list from session (for AJAX use only)
	 * @param request
	 * @return ID list
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping( value = "/getEventSetIdList" )
	public List<String> getEventSetIdListFromSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<String> eventSetIdList = (List<String>) session.getAttribute("idlist");
		
		if (eventSetIdList == null) {
			eventSetIdList = new ArrayList<>();
		}
		
		System.out.println(eventSetIdList);
		
		return eventSetIdList;
	}
	
	/**
	 * Convert input date string to valid SOAP date string<br/>
	 * @param inputDateString input date from form
	 * @return date string in dd-MM-yyyy
	 * @throws ParseException
	 */
	private static String getConvertedDateString(String inputDateString) throws ParseException {
		return serviceDateFormat.format(inputDateFormat.parse(inputDateString));
	}
	
}