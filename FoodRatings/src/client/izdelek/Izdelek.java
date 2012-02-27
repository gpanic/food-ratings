//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package client.izdelek;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Izdelek complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Izdelek">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kategorija" type="{http://KISFoodLib}Kategorija" minOccurs="0"/>
 *         &lt;element name="proizvajalec" type="{http://KISFoodLib}Proizvajalec" minOccurs="0"/>
 *         &lt;element name="drzavaIzvora" type="{http://KISFoodLib}Drzava" minOccurs="0"/>
 *         &lt;element name="ocene" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Izdelek", namespace = "http://KISFoodLib", propOrder = {
    "id",
    "naziv",
    "kategorija",
    "proizvajalec",
    "drzavaIzvora",
    "ocene"
})
public class Izdelek {

    protected Integer id;
    protected String naziv;
    protected Kategorija kategorija;
    protected Proizvajalec proizvajalec;
    protected Drzava drzavaIzvora;
    @XmlElement(type = Integer.class)
    protected List<Integer> ocene;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the naziv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Sets the value of the naziv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaziv(String value) {
        this.naziv = value;
    }

    /**
     * Gets the value of the kategorija property.
     * 
     * @return
     *     possible object is
     *     {@link Kategorija }
     *     
     */
    public Kategorija getKategorija() {
        return kategorija;
    }

    /**
     * Sets the value of the kategorija property.
     * 
     * @param value
     *     allowed object is
     *     {@link Kategorija }
     *     
     */
    public void setKategorija(Kategorija value) {
        this.kategorija = value;
    }

    /**
     * Gets the value of the proizvajalec property.
     * 
     * @return
     *     possible object is
     *     {@link Proizvajalec }
     *     
     */
    public Proizvajalec getProizvajalec() {
        return proizvajalec;
    }

    /**
     * Sets the value of the proizvajalec property.
     * 
     * @param value
     *     allowed object is
     *     {@link Proizvajalec }
     *     
     */
    public void setProizvajalec(Proizvajalec value) {
        this.proizvajalec = value;
    }

    /**
     * Gets the value of the drzavaIzvora property.
     * 
     * @return
     *     possible object is
     *     {@link Drzava }
     *     
     */
    public Drzava getDrzavaIzvora() {
        return drzavaIzvora;
    }

    /**
     * Sets the value of the drzavaIzvora property.
     * 
     * @param value
     *     allowed object is
     *     {@link Drzava }
     *     
     */
    public void setDrzavaIzvora(Drzava value) {
        this.drzavaIzvora = value;
    }

    /**
     * Gets the value of the ocene property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ocene property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOcene().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getOcene() {
        if (ocene == null) {
            ocene = new ArrayList<Integer>();
        }
        return this.ocene;
    }

}