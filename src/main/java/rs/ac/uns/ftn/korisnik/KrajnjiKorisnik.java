//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.05.29 at 10:17:58 PM CEST 
//


package rs.ac.uns.ftn.korisnik;

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
 *     &lt;extension base="{http://www.ftn.uns.ac.rs/korisnik}TKorisnik">
 *       &lt;sequence>
 *         &lt;element name="Ulogovan" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "ulogovan"
})
@XmlRootElement(name = "Krajnji_korisnik")
public class KrajnjiKorisnik
    extends TKorisnik
{

    @XmlElement(name = "Ulogovan")
    protected boolean ulogovan;

    /**
     * Gets the value of the ulogovan property.
     * 
     */
    public boolean isUlogovan() {
        return ulogovan;
    }

    /**
     * Sets the value of the ulogovan property.
     * 
     */
    public void setUlogovan(boolean value) {
        this.ulogovan = value;
    }

}
