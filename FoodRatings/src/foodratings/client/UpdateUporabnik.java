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
 *         &lt;element name="uporabnik" type="{http://KISFoodLib}Uporabnik"/>
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
    "uporabnik"
})
@XmlRootElement(name = "updateUporabnik")
public class UpdateUporabnik {

    @XmlElement(required = true, nillable = true)
    protected Uporabnik uporabnik;

    /**
     * Gets the value of the uporabnik property.
     * 
     * @return
     *     possible object is
     *     {@link Uporabnik }
     *     
     */
    public Uporabnik getUporabnik() {
        return uporabnik;
    }

    /**
     * Sets the value of the uporabnik property.
     * 
     * @param value
     *     allowed object is
     *     {@link Uporabnik }
     *     
     */
    public void setUporabnik(Uporabnik value) {
        this.uporabnik = value;
    }

}
