
package students;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAvatar complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="getAvatar"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="studentName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAvatar", propOrder = {
        "studentName"
})
public class GetAvatar {

    @XmlElement(required = true)
    protected String studentName;

    /**
     * Gets the value of the studentName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Sets the value of the studentName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStudentName(String value) {
        this.studentName = value;
    }

}
