
package au.edu.unsw.sltf.currency;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element name="rate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="asAt" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "rate",
    "asAt"
})
@XmlRootElement(name = "exchangeRateResponseMsg")
public class ExchangeRateResponseMsg {

    @XmlElement(required = true)
    protected String rate;
    @XmlElement(required = true)
    protected String asAt;

    /**
     * Gets the value of the rate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRate() {
        return rate;
    }

    /**
     * Sets the value of the rate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRate(String value) {
        this.rate = value;
    }

    /**
     * Gets the value of the asAt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAsAt() {
        return asAt;
    }

    /**
     * Sets the value of the asAt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAsAt(String value) {
        this.asAt = value;
    }

}
