package au.edu.unsw.sltf.marketdatautil;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.0.4
 * 2015-09-04T14:37:19.385+10:00
 * Generated source version: 3.0.4
 * 
 */
@WebServiceClient(name = "MarketDataUtilServicePortTypeImplService", 
                  wsdlLocation = "http://localhost:8080/9322ass1/marketDataUtilService?wsdl",
                  targetNamespace = "http://marketdatautil.sltf.unsw.edu.au/") 
public class MarketDataUtilServicePortTypeImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://marketdatautil.sltf.unsw.edu.au/", "MarketDataUtilServicePortTypeImplService");
    public final static QName MarketDataUtilServicePortTypeImplPort = new QName("http://marketdatautil.sltf.unsw.edu.au/", "MarketDataUtilServicePortTypeImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/9322ass1/marketDataUtilService?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(MarketDataUtilServicePortTypeImplService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/9322ass1/marketDataUtilService?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public MarketDataUtilServicePortTypeImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public MarketDataUtilServicePortTypeImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MarketDataUtilServicePortTypeImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public MarketDataUtilServicePortTypeImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public MarketDataUtilServicePortTypeImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public MarketDataUtilServicePortTypeImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    

    /**
     *
     * @return
     *     returns MarketDataUtilServicePortType
     */
    @WebEndpoint(name = "MarketDataUtilServicePortTypeImplPort")
    public MarketDataUtilServicePortType getMarketDataUtilServicePortTypeImplPort() {
        return super.getPort(MarketDataUtilServicePortTypeImplPort, MarketDataUtilServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MarketDataUtilServicePortType
     */
    @WebEndpoint(name = "MarketDataUtilServicePortTypeImplPort")
    public MarketDataUtilServicePortType getMarketDataUtilServicePortTypeImplPort(WebServiceFeature... features) {
        return super.getPort(MarketDataUtilServicePortTypeImplPort, MarketDataUtilServicePortType.class, features);
    }

}
