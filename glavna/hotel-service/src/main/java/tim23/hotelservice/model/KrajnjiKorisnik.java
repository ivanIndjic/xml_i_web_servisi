//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.13 at 08:09:59 PM CEST 
//


package tim23.hotelservice.model;

import java.util.ArrayList;
import java.util.List;
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
 *     &lt;extension base="{http://www.ftn.uns.ac.rs/entiteti}TKorisnik">
 *       &lt;sequence>
 *         &lt;element name="Blokiran" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/entiteti}Poruka" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Uklonjen" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "blokiran",
    "poruka",
    "uklonjen"
})
@XmlRootElement(name = "Krajnji_korisnik")
public class KrajnjiKorisnik
    extends TKorisnik
{

    @XmlElement(name = "Blokiran")
    protected boolean blokiran;
    @XmlElement(name = "Poruka")
    protected List<Poruka> poruka;
    @XmlElement(name = "Uklonjen")
    protected boolean uklonjen;

    /**
     * Gets the value of the blokiran property.
     * 
     */
    public boolean isBlokiran() {
        return blokiran;
    }

    /**
     * Sets the value of the blokiran property.
     * 
     */
    public void setBlokiran(boolean value) {
        this.blokiran = value;
    }

    /**
     * Gets the value of the poruka property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the poruka property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPoruka().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Poruka }
     * 
     * 
     */
    public List<Poruka> getPoruka() {
        if (poruka == null) {
            poruka = new ArrayList<Poruka>();
        }
        return this.poruka;
    }

    /**
     * Gets the value of the uklonjen property.
     * 
     */
    public boolean isUklonjen() {
        return uklonjen;
    }

    /**
     * Sets the value of the uklonjen property.
     * 
     */
    public void setUklonjen(boolean value) {
        this.uklonjen = value;
    }

}
