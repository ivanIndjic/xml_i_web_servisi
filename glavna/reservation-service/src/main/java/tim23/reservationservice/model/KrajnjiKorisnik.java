//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.13 at 08:16:54 PM CEST 
//


package tim23.reservationservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
  //  "poruka",
    "uklonjen"
})
@XmlRootElement(name = "Krajnji_korisnik")
@Entity
public class KrajnjiKorisnik
    extends TKorisnik
{

    @XmlElement(name = "Blokiran")
    @Column
    protected Boolean blokiran;
    
//    @XmlElement(name = "Primljene_poruke")
//    @OneToMany(mappedBy="idPrimaoca")
//    protected List<Poruka> primljenePoruke;
//    
//    @XmlElement(name = "Poslate_poruke")
//    @OneToMany(mappedBy="idPosiljaoca")
//    private List<Poruka> poslatePoruke;
    
    @XmlElement(name = "Uklonjen")
    @Column
    protected Boolean uklonjen;

    /**
     * Gets the value of the blokiran property.
     * 
     */
    public Boolean isBlokiran() {
        return blokiran;
    }

    /**
     * Sets the value of the blokiran property.
     * 
     */
    public void setBlokiran(Boolean value) {
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
    
    /**
     * Gets the value of the uklonjen property.
     * 
     */
    public Boolean isUklonjen() {
        return uklonjen;
    }


//	public List<Poruka> getPrimljenePoruke() {
//		return primljenePoruke;
//	}
//
//	public void setPrimljenePoruke(List<Poruka> primljenePoruke) {
//		this.primljenePoruke = primljenePoruke;
//	}
//
//	public List<Poruka> getPoslatePoruke() {
//		return poslatePoruke;
//	}
//
//	public void setPoslatePoruke(List<Poruka> poslatePoruke) {
//		this.poslatePoruke = poslatePoruke;
//	}
//
//	public Boolean getUklonjen() {
//		return uklonjen;
//	}

	/**
     * Sets the value of the uklonjen property.
     * 
     */
    public void setUklonjen(Boolean value) {
        this.uklonjen = value;
    }

}
