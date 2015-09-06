
package au.edu.unsw.sltf.marketdatautil;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MarketDataUtilFaultType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MarketDataUtilFaultType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="InvalidCurrencyCode"/&gt;
 *     &lt;enumeration value="InvalidEventSetId"/&gt;
 *     &lt;enumeration value="InvalidMarketData"/&gt;
 *     &lt;enumeration value="ProgramError"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "MarketDataUtilFaultType")
@XmlEnum
public enum MarketDataUtilFaultType {

    @XmlEnumValue("InvalidCurrencyCode")
    INVALID_CURRENCY_CODE("InvalidCurrencyCode"),
    @XmlEnumValue("InvalidEventSetId")
    INVALID_EVENT_SET_ID("InvalidEventSetId"),
    @XmlEnumValue("InvalidMarketData")
    INVALID_MARKET_DATA("InvalidMarketData"),
    @XmlEnumValue("ProgramError")
    PROGRAM_ERROR("ProgramError");
    private final String value;

    MarketDataUtilFaultType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MarketDataUtilFaultType fromValue(String v) {
        for (MarketDataUtilFaultType c: MarketDataUtilFaultType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
