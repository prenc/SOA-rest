
package students;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAvatarResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="getAvatarResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="imageString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAvatarResponse", propOrder = {
        "imageString"
})
public class GetAvatarResponse {

    protected String imageString;

    /**
     * Gets the value of the imageString property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getImageString() {
        return imageString;
    }

    /**
     * Sets the value of the imageString property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setImageString(String value) {
        this.imageString = value;
    }

}
