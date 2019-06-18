//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.13 at 08:16:54 PM CEST 
//


package tim23.reservationservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="Grad" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Drzava" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Ulica_i_broj" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "id",
    "grad",
    "drzava",
    "ulicaIBroj"
})
@XmlRootElement(name = "Adresa")
@Entity
@Table(name = "adresa")
public class Adresa {

    @XmlElement(name = "Id", required = true)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    
    @XmlElement(name = "Grad", required = true)
    @Column(name = "grad")
    private String grad;
    
    @XmlElement(name = "Drzava", required = true)
    @Column(name="drzava")
    private String drzava;
    
    @XmlElement(name = "Ulica_i_broj", required = true)
    @Column(name = "ulicaibroj")
    private String ulicaIBroj;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
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
     *     {@link Object }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the grad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrad() {
        return grad;
    }

    /**
     * Sets the value of the grad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrad(String value) {
        this.grad = value;
    }

    /**
     * Gets the value of the drzava property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrzava() {
        return drzava;
    }

    /**
     * Sets the value of the drzava property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrzava(String value) {
        this.drzava = value;
    }

    /**
     * Gets the value of the ulicaIBroj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUlicaIBroj() {
        return ulicaIBroj;
    }

    /**
     * Sets the value of the ulicaIBroj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUlicaIBroj(String value) {
        this.ulicaIBroj = value;
    }

}
