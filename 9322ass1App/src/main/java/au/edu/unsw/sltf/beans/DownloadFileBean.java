package au.edu.unsw.sltf.beans;

import java.io.Serializable;
import java.util.List;

public class DownloadFileBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 440729998469051956L;
	private String dataURL;
	
	private List<String> idList;

	public String getDataURL() {
		return dataURL;
	}

	public void setDataURL(String dataURL) {
		this.dataURL = dataURL;
	}

	public List<String> getIdList() {
		return idList;
	}

	public void setIdList(List<String> idList) {
		this.idList = idList;
	}
}
