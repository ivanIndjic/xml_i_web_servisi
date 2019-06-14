//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.13 at 08:16:54 PM CEST 
//


package tim23.searchservice.model;

import java.util.Date;

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
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="Id_cene" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Pocetak_vazenja" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Kraj_vazenja" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Vrednost" type="{http://www.w3.org/2001/XMLSchema}double"/>
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
    "idCene",
    "pocetakVazenja",
    "krajVazenja",
    "vrednost"
})
@XmlRootElement(name = "Cena")
@Entity
public class Cena {

    @XmlElement(name = "Id_cene")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idCene;
    
    @XmlElement(name = "Pocetak_vazenja", required = true)
    @XmlSchemaType(name = "date")
    @Column
    private Date pocetakVazenja;
    
    @XmlElement(name = "Kraj_vazenja", required = true)
    @XmlSchemaType(name = "date")
    @Column
    private Date krajVazenja;
    
    @XmlElement(name = "Vrednost")
    @Column
    private Double vrednost;
    
    @ManyToOne
    @JoinColumn(name = "id_sobe")
    private Soba soba;

    /**
     * Gets the value of the idCene property.
     * 
     */
    public int getIdCene() {
        return idCene;
    }

    /**
     * Sets the value of the idCene property.
     * 
     */
    public void setIdCene(int value) {
        this.idCene = value;
    }

    /**
     * Gets the value of the pocetakVazenja property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public Date getPocetakVazenja() {
        return pocetakVazenja;
    }

    /**
     * Sets the value of the pocetakVazenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPocetakVazenja(Date value) {
        this.pocetakVazenja = value;
    }

    /**
     * Gets the value of the krajVazenja property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public Date getKrajVazenja() {
        return krajVazenja;
    }

    /**
     * Sets the value of the krajVazenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setKrajVazenja(Date value) {
        this.krajVazenja = value;
    }

    /**
     * Gets the value of the vrednost property.
     * 
     */
    public double getVrednost() {
        return vrednost;
    }

    /**
     * Sets the value of the vrednost property.
     * 
     */
    public void setVrednost(double value) {
        this.vrednost = value;
    }

}
