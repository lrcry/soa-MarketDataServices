
package au.edu.unsw.sltf.marketdatautil;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the au.edu.unsw.sltf.marketdatautil package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: au.edu.unsw.sltf.marketdatautil
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConvertMarketDataRequestMsg }
     * 
     */
    public ConvertMarketDataRequestMsg createConvertMarketDataRequestMsg() {
        return new ConvertMarketDataRequestMsg();
    }

    /**
     * Create an instance of {@link ConvertMarketDataResponseMsg }
     * 
     */
    public ConvertMarketDataResponseMsg createConvertMarketDataResponseMsg() {
        return new ConvertMarketDataResponseMsg();
    }

    /**
     * Create an instance of {@link SummaryMarketDataRequestMsg }
     * 
     */
    public SummaryMarketDataRequestMsg createSummaryMarketDataRequestMsg() {
        return new SummaryMarketDataRequestMsg();
    }

    /**
     * Create an instance of {@link SummaryMarketDataResponseMsg }
     * 
     */
    public SummaryMarketDataResponseMsg createSummaryMarketDataResponseMsg() {
        return new SummaryMarketDataResponseMsg();
    }

    /**
     * Create an instance of {@link MarketDataUtilFaultMsg }
     * 
     */
    public MarketDataUtilFaultMsg createMarketDataUtilFaultMsg() {
        return new MarketDataUtilFaultMsg();
    }

}
