
package au.edu.unsw.sltf.services;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.0.4
 * 2015-09-03T11:35:41.693+10:00
 * Generated source version: 3.0.4
 */

@WebFault(name = "importDownloadFault", targetNamespace = "http://sltf.unsw.edu.au/services")
public class ImportDownloadFaultException extends Exception {
    
    private au.edu.unsw.sltf.services.ImportDownloadFault importDownloadFault;

    public ImportDownloadFaultException() {
        super();
    }
    
    public ImportDownloadFaultException(String message) {
        super(message);
    }
    
    public ImportDownloadFaultException(String message, Throwable cause) {
        super(message, cause);
    }

    public ImportDownloadFaultException(String message, au.edu.unsw.sltf.services.ImportDownloadFault importDownloadFault) {
        super(message);
        this.importDownloadFault = importDownloadFault;
    }

    public ImportDownloadFaultException(String message, au.edu.unsw.sltf.services.ImportDownloadFault importDownloadFault, Throwable cause) {
        super(message, cause);
        this.importDownloadFault = importDownloadFault;
    }

    public au.edu.unsw.sltf.services.ImportDownloadFault getFaultInfo() {
        return this.importDownloadFault;
    }
}
