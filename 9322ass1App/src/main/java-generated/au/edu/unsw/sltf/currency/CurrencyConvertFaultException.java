
package au.edu.unsw.sltf.currency;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.0.4
 * 2015-09-03T11:38:19.018+10:00
 * Generated source version: 3.0.4
 */

@WebFault(name = "currencyConvertFault", targetNamespace = "http://sltf.unsw.edu.au/currency")
public class CurrencyConvertFaultException extends Exception {
    
    private au.edu.unsw.sltf.currency.CurrencyConvertFault currencyConvertFault;

    public CurrencyConvertFaultException() {
        super();
    }
    
    public CurrencyConvertFaultException(String message) {
        super(message);
    }
    
    public CurrencyConvertFaultException(String message, Throwable cause) {
        super(message, cause);
    }

    public CurrencyConvertFaultException(String message, au.edu.unsw.sltf.currency.CurrencyConvertFault currencyConvertFault) {
        super(message);
        this.currencyConvertFault = currencyConvertFault;
    }

    public CurrencyConvertFaultException(String message, au.edu.unsw.sltf.currency.CurrencyConvertFault currencyConvertFault, Throwable cause) {
        super(message, cause);
        this.currencyConvertFault = currencyConvertFault;
    }

    public au.edu.unsw.sltf.currency.CurrencyConvertFault getFaultInfo() {
        return this.currencyConvertFault;
    }
}
