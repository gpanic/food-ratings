//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package client.izdelek;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Izdelki complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Izdelki">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="izdelki" type="{http://KISFoodLib}Izdelki" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Izdelki", namespace = "http://KISFoodLib", propOrder = {
    "izdelki"
})
public class Izdelki {

    protected List<Izdelki> izdelki;

    /**
     * Gets the value of the izdelki property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the izdelki property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIzdelki().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Izdelki }
     * 
     * 
     */
    public List<Izdelki> getIzdelki() {
        if (izdelki == null) {
            izdelki = new ArrayList<Izdelki>();
        }
        return this.izdelki;
    }

}
