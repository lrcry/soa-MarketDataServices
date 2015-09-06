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
 * 2015-09-05T15:40:52.246+10:00
 * Generated source version: 3.0.4
 * 
 */
@WebServiceClient(name = "MarketDataUtilService", 
                  wsdlLocation = "file:/Users/hansmong/SpringToolSuite/workspace-sts-3.6.4.RELEASE/9322ass1/src/main/resources/wsdl/marketDataUtil.wsdl",
                  targetNamespace = "http://sltf.unsw.edu.au/marketdatautil") 
public class MarketDataUtilService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://sltf.unsw.edu.au/marketdatautil", "MarketDataUtilService");
    public final static QName MarketDataUtilServiceHttpSoap11Endpoint = new QName("http://sltf.unsw.edu.au/marketdatautil", "MarketDataUtilServiceHttpSoap11Endpoint");
    static {
        URL url = null;
        try {
            url = new URL("file:/Users/hansmong/SpringToolSuite/workspace-sts-3.6.4.RELEASE/9322ass1/src/main/resources/wsdl/marketDataUtil.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(MarketDataUtilService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/Users/hansmong/SpringToolSuite/workspace-sts-3.6.4.RELEASE/9322ass1/src/main/resources/wsdl/marketDataUtil.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public MarketDataUtilService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public MarketDataUtilService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MarketDataUtilService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public MarketDataUtilService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public MarketDataUtilService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public MarketDataUtilService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    

    /**
     *
     * @return
     *     returns MarketDataUtilServicePortType
     */
    @WebEndpoint(name = "MarketDataUtilServiceHttpSoap11Endpoint")
    public MarketDataUtilServicePortType getMarketDataUtilServiceHttpSoap11Endpoint() {
        return super.getPort(MarketDataUtilServiceHttpSoap11Endpoint, MarketDataUtilServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MarketDataUtilServicePortType
     */
    @WebEndpoint(name = "MarketDataUtilServiceHttpSoap11Endpoint")
    public MarketDataUtilServicePortType getMarketDataUtilServiceHttpSoap11Endpoint(WebServiceFeature... features) {
        return super.getPort(MarketDataUtilServiceHttpSoap11Endpoint, MarketDataUtilServicePortType.class, features);
    }

}