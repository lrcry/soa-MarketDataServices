package au.edu.unsw.sltf.beans;

import java.io.Serializable;
import java.util.List;

public class SummaryMarketDataBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6391526757487733437L;
	private String eventSetId;
	private String sec;
	private String startDate;
	private String endDate;
	private String currencyCode;
	private String numberOfLines;
	
	private List<String> idList;
	
	public String getEventSetId() {
		return eventSetId;
	}
	public void setEventSetId(String eventSetId) {
		this.eventSetId = eventSetId;
	}
	public String getSec() {
		return sec;
	}
	public void setSec(String sec) {
		this.sec = sec;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getNumberOfLines() {
		return numberOfLines;
	}
	public void setNumberOfLines(String numberOfLines) {
		this.numberOfLines = numberOfLines;
	}
	

	public List<String> getIdList() {
		return idList;
	}

	public void setIdList(List<String> idList) {
		this.idList = idList;
	}
}
