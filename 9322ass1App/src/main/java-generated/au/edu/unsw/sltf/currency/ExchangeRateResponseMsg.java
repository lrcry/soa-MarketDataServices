
package au.edu.unsw.sltf.currency;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取rate属性的值。
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
     * 设置rate属性的值。
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
     * 获取asAt属性的值。
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
     * 设置asAt属性的值。
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
