//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.13 at 08:16:54 PM CEST 
//


package tim23.agent.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/entiteti}Tip_smestaja"/>
 *         &lt;element name="Opis_smestaja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/entiteti}Dodatne_usluge" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Slika" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/entiteti}Cena" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/entiteti}Rezervacija" maxOccurs="unbounded" minOccurs="0"/>
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
    "idAgenta",
    "tipSmestaja",
    "opisSmestaja",
    "dodatneUsluge",
    "slika",
    "cena",
    "rezervacija"
})
@XmlRootElement(name = "Soba")
@Entity
public class Soba {

    @XmlElement(name = "Id_soba")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idSoba;
    
    @XmlElement(name = "Broj_sobe")
    @Column
    private Integer brojSobe;
    
    @XmlElement(name = "Broj_kreveta")
    @Column
    private Integer brojKreveta;
    
    @XmlElement(name = "Ocena")
    @Column
    private Double ocena;
    
    @XmlElement(name = "Odobreno")
    private Boolean odobreno;
    
    @XmlElement(name = "Adresa", required = true)
    @ManyToOne
    @JoinColumn(name="adresa")
    private Adresa adresa;
    
    @XmlElement(name = "Id_agenta")
    @ManyToOne
    @JoinColumn(name="agent")
    private Integer idAgenta;
    
    @XmlElement(name = "Tip_smestaja", required = true)
    @ManyToOne
    @JoinColumn(name="tip_smestaja")
    private TipSmestaja tipSmestaja;
    
    @XmlElement(name = "Opis_smestaja", required = true)
    private String opisSmestaja;
    
    @XmlElement(name = "Rezervacija")
    protected List<Rezervacija> rezervacija;

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
    public void setIdSoba(Integer value) {
        this.idSoba = value;
    }

    /**
     * Gets the value of the brojSobe property.
     * 
     */
    public Integer getBrojSobe() {
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
    public void setIdAgenta(Integer value) {
        this.idAgenta = value;
    }

    /**
     * Gets the value of the tipSmestaja property.
     * 
     * @return
     *     possible object is
     *     {@link TipSmestaja }
     *     
     */
    public TipSmestaja getTipSmestaja() {
        return tipSmestaja;
    }

    /**
     * Sets the value of the tipSmestaja property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipSmestaja }
     *     
     */
    public void setTipSmestaja(TipSmestaja value) {
        this.tipSmestaja = value;
    }

    /**
     * Gets the value of the opisSmestaja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpisSmestaja() {
        return opisSmestaja;
    }

    /**
     * Sets the value of the opisSmestaja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpisSmestaja(String value) {
        this.opisSmestaja = value;
    }


}
