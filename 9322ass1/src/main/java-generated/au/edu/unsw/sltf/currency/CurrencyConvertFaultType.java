
package au.edu.unsw.sltf.currency;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for currencyConvertFaultType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="currencyConvertFaultType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="InvalidCurrencyCode"/&gt;
 *     &lt;enumeration value="InvalidServiceCode"/&gt;
 *     &lt;enumeration value="ProgramError"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "currencyConvertFaultType")
@XmlEnum
public enum CurrencyConvertFaultType {

    @XmlEnumValue("InvalidCurrencyCode")
    INVALID_CURRENCY_CODE("InvalidCurrencyCode"),
    @XmlEnumValue("InvalidServiceCode")
    INVALID_SERVICE_CODE("InvalidServiceCode"),
    @XmlEnumValue("ProgramError")
    PROGRAM_ERROR("ProgramError");
    private final String value;

    CurrencyConvertFaultType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CurrencyConvertFaultType fromValue(String v) {
        for (CurrencyConvertFaultType c: CurrencyConvertFaultType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
