//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.05.29 at 10:17:58 PM CEST 
//


package rs.ac.uns.ftn.korisnik;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import rs.ac.uns.ftn.entiteti.Soba;


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
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/entiteti}Soba" maxOccurs="unbounded"/>
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
    "soba"
})
@XmlRootElement(name = "Agent")
public class Agent
    extends TKorisnik
{

    @XmlElement(name = "Soba", namespace = "http://www.ftn.uns.ac.rs/entiteti", required = true)
    protected List<Soba> soba;

    /**
     * Gets the value of the soba property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the soba property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSoba().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Soba }
     * 
     * 
     */
    public List<Soba> getSoba() {
        if (soba == null) {
            soba = new ArrayList<Soba>();
        }
        return this.soba;
    }

}
