//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.13 at 08:16:54 PM CEST 
//


package tim23.reservationservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 *         &lt;element name="Id_ocene" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/entiteti}Krajnji_korisnik"/>
 *         &lt;element name="Ocena" type="{http://www.w3.org/2001/XMLSchema}double"/>
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
    "idOcene",
    "krajnjiKorisnik",
    "ocena"
})
@XmlRootElement(name = "Ocena_smestaja")
public class OcenaSmestaja {

    @XmlElement(name = "Id_ocene")
    protected long idOcene;
    
    @XmlElement(name = "Krajnji_korisnik", required = true)
    protected KrajnjiKorisnik krajnjiKorisnik;
    @XmlElement(name = "Ocena")
    protected double ocena;

    /**
     * Gets the value of the idOcene property.
     * 
     */
    public long getIdOcene() {
        return idOcene;
    }

    /**
     * Sets the value of the idOcene property.
     * 
     */
    public void setIdOcene(long value) {
        this.idOcene = value;
    }

    /**
     * Gets the value of the krajnjiKorisnik property.
     * 
     * @return
     *     possible object is
     *     {@link KrajnjiKorisnik }
     *     
     */
    public KrajnjiKorisnik getKrajnjiKorisnik() {
        return krajnjiKorisnik;
    }

    /**
     * Sets the value of the krajnjiKorisnik property.
     * 
     * @param value
     *     allowed object is
     *     {@link KrajnjiKorisnik }
     *     
     */
    public void setKrajnjiKorisnik(KrajnjiKorisnik value) {
        this.krajnjiKorisnik = value;
    }

    /**
     * Gets the value of the ocena property.
     * 
     */
    public double getOcena() {
        return ocena;
    }

    /**
     * Sets the value of the ocena property.
     * 
     */
    public void setOcena(double value) {
        this.ocena = value;
    }

}
