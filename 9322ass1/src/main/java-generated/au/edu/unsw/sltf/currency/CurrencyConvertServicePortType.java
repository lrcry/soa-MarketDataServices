package au.edu.unsw.sltf.currency;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;

/**
 * This class was generated by Apache CXF 3.0.4
 * 2015-09-05T15:40:51.956+10:00
 * Generated source version: 3.0.4
 * 
 */
@WebService(targetNamespace = "http://sltf.unsw.edu.au/currency", name = "CurrencyConvertServicePortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface CurrencyConvertServicePortType {

    @WebResult(name = "exchangeRateResponseMsg", targetNamespace = "http://sltf.unsw.edu.au/currency", partName = "parameters")
    @Action(input = "urn:exchangeRateRequestMsg", output = "urn:exchangeRateResponseMsg", fault = {})
    @WebMethod(action = "urn:exchangeRateRequestMsg")
    public ExchangeRateResponseMsg yahooExchangeRate(
        @WebParam(partName = "parameters", name = "exchangeRateRequestMsg", targetNamespace = "http://sltf.unsw.edu.au/currency")
        ExchangeRateRequestMsg parameters
    ) throws CurrencyConvertFault_Exception;
}
