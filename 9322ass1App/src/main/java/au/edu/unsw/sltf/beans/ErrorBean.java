package au.edu.unsw.sltf.beans;

import java.io.Serializable;

public class ErrorBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5557012709001696323L;
	private String errorMessage;
	private String errCode;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	
}
