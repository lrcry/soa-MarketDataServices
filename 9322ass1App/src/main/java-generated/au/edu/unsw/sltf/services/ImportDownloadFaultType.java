
package au.edu.unsw.sltf.services;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>importDownloadFaultType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="importDownloadFaultType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="InvalidEventSetId"/&gt;
 *     &lt;enumeration value="InvalidURL"/&gt;
 *     &lt;enumeration value="InvalidSECCode"/&gt;
 *     &lt;enumeration value="InvalidDates"/&gt;
 *     &lt;enumeration value="InvalidFileType"/&gt;
 *     &lt;enumeration value="ProgramError"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "importDownloadFaultType")
@XmlEnum
public enum ImportDownloadFaultType {

    @XmlEnumValue("InvalidEventSetId")
    INVALID_EVENT_SET_ID("InvalidEventSetId"),
    @XmlEnumValue("InvalidURL")
    INVALID_URL("InvalidURL"),
    @XmlEnumValue("InvalidSECCode")
    INVALID_SEC_CODE("InvalidSECCode"),
    @XmlEnumValue("InvalidDates")
    INVALID_DATES("InvalidDates"),
    @XmlEnumValue("InvalidFileType")
    INVALID_FILE_TYPE("InvalidFileType"),
    @XmlEnumValue("ProgramError")
    PROGRAM_ERROR("ProgramError");
    private final String value;

    ImportDownloadFaultType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ImportDownloadFaultType fromValue(String v) {
        for (ImportDownloadFaultType c: ImportDownloadFaultType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
