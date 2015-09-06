
package au.edu.unsw.sltf.marketdatautil;

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
 *         &lt;element name="eventSetId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="sec" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="currencyCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="numberOfLines" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    "eventSetId",
    "sec",
    "startDate",
    "endDate",
    "currencyCode",
    "numberOfLines"
})
@XmlRootElement(name = "summaryMarketDataResponseMsg")
public class SummaryMarketDataResponseMsg {

    @XmlElement(required = true)
    protected String eventSetId;
    @XmlElement(required = true)
    protected String sec;
    @XmlElement(required = true)
    protected String startDate;
    @XmlElement(required = true)
    protected String endDate;
    @XmlElement(required = true)
    protected String currencyCode;
    protected int numberOfLines;

    /**
     * Gets the value of the eventSetId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventSetId() {
        return eventSetId;
    }

    /**
     * Sets the value of the eventSetId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventSetId(String value) {
        this.eventSetId = value;
    }

    /**
     * Gets the value of the sec property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSec() {
        return sec;
    }

    /**
     * Sets the value of the sec property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSec(String value) {
        this.sec = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(String value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the numberOfLines property.
     * 
     */
    public int getNumberOfLines() {
        return numberOfLines;
    }

    /**
     * Sets the value of the numberOfLines property.
     * 
     */
    public void setNumberOfLines(int value) {
        this.numberOfLines = value;
    }

}
