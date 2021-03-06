//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.05.29 at 10:17:58 PM CEST 
//


package rs.ac.uns.ftn.entiteti;

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
 *         &lt;element name="Id_soba" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Broj_sobe" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Broj_kreveta" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Ocena" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Odobreno" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/entiteti}Adresa"/>
 *         &lt;element name="Id_agenta" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "idSoba",
    "brojSobe",
    "brojKreveta",
    "ocena",
    "odobreno",
    "adresa",
    "idAgenta"
})
@XmlRootElement(name = "Soba")
public class Soba {

    @XmlElement(name = "Id_soba")
    protected long idSoba;
    @XmlElement(name = "Broj_sobe")
    protected int brojSobe;
    @XmlElement(name = "Broj_kreveta")
    protected int brojKreveta;
    @XmlElement(name = "Ocena")
    protected double ocena;
    @XmlElement(name = "Odobreno")
    protected boolean odobreno;
    @XmlElement(name = "Adresa", required = true)
    protected Adresa adresa;
    @XmlElement(name = "Id_agenta")
    protected long idAgenta;

    /**
     * Gets the value of the idSoba property.
     * 
     */
    public long getIdSoba() {
        return idSoba;
    }

    /**
     * Sets the value of the idSoba property.
     * 
     */
    public void setIdSoba(long value) {
        this.idSoba = value;
    }

    /**
     * Gets the value of the brojSobe property.
     * 
     */
    public int getBrojSobe() {
        return brojSobe;
    }

    /**
     * Sets the value of the brojSobe property.
     * 
     */
    public void setBrojSobe(int value) {
        this.brojSobe = value;
    }

    /**
     * Gets the value of the brojKreveta property.
     * 
     */
    public int getBrojKreveta() {
        return brojKreveta;
    }

    /**
     * Sets the value of the brojKreveta property.
     * 
     */
    public void setBrojKreveta(int value) {
        this.brojKreveta = value;
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

    /**
     * Gets the value of the odobreno property.
     * 
     */
    public boolean isOdobreno() {
        return odobreno;
    }

    /**
     * Sets the value of the odobreno property.
     * 
     */
    public void setOdobreno(boolean value) {
        this.odobreno = value;
    }

    /**
     * Gets the value of the adresa property.
     * 
     * @return
     *     possible object is
     *     {@link Adresa }
     *     
     */
    public Adresa getAdresa() {
        return adresa;
    }

    /**
     * Sets the value of the adresa property.
     * 
     * @param value
     *     allowed object is
     *     {@link Adresa }
     *     
     */
    public void setAdresa(Adresa value) {
        this.adresa = value;
    }

    /**
     * Gets the value of the idAgenta property.
     * 
     */
    public long getIdAgenta() {
        return idAgenta;
    }

    /**
     * Sets the value of the idAgenta property.
     * 
     */
    public void setIdAgenta(long value) {
        this.idAgenta = value;
    }

}
