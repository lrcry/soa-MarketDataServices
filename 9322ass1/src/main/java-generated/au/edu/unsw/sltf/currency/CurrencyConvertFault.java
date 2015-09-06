
package au.edu.unsw.sltf.currency;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="faultType" type="{http://sltf.unsw.edu.au/currency}currencyConvertFaultType"/&gt;
 *         &lt;element name="faultMessage" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "faultType",
    "faultMessage"
})
@XmlRootElement(name = "currencyConvertFault")
public class CurrencyConvertFault {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyConvertFaultType faultType;
    @XmlElement(required = true)
    protected String faultMessage;

    /**
     * Gets the value of the faultType property.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyConvertFaultType }
     *     
     */
    public CurrencyConvertFaultType getFaultType() {
        return faultType;
    }

    /**
     * Sets the value of the faultType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyConvertFaultType }
     *     
     */
    public void setFaultType(CurrencyConvertFaultType value) {
        this.faultType = value;
    }

    /**
     * Gets the value of the faultMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaultMessage() {
        return faultMessage;
    }

    /**
     * Sets the value of the faultMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaultMessage(String value) {
        this.faultMessage = value;
    }

}