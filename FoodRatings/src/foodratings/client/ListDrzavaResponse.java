//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package foodratings.client;

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
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="drzave" type="{http://KISFoodLib}Drzave"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "drzave"
})
@XmlRootElement(name = "listDrzavaResponse")
public class ListDrzavaResponse {

    @XmlElement(required = true, nillable = true)
    protected Drzave drzave;

    /**
     * Gets the value of the drzave property.
     * 
     * @return
     *     possible object is
     *     {@link Drzave }
     *     
     */
    public Drzave getDrzave() {
        return drzave;
    }

    /**
     * Sets the value of the drzave property.
     * 
     * @param value
     *     allowed object is
     *     {@link Drzave }
     *     
     */
    public void setDrzave(Drzave value) {
        this.drzave = value;
    }

}
