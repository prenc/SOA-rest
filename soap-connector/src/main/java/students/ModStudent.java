
package students;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for modStudent complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="modStudent"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="studentName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="studentHeight" type="{http://students/}subject" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modStudent", propOrder = {
        "studentName",
        "studentHeight"
})
public class ModStudent {

    @XmlElement(required = true)
    protected String studentName;
    @XmlElement(required = true)
    protected List<Subject> studentHeight;

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

    /**
     * Gets the value of the studentHeight property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the studentHeight property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStudentHeight().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Subject }
     */
    public List<Subject> getStudentHeight() {
        if (studentHeight == null) {
            studentHeight = new ArrayList<Subject>();
        }
        return this.studentHeight;
    }

}
