//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2021.12.16 um 04:58:56 PM CET 
//


package com.bechtle.eagl.webapp.model.metadata;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für MBaseEntity complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="MBaseEntity"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ignore" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ignoreIfSet" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{https://www.mathplan.de/moses/xsd/default}MId"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MBaseEntity", namespace = "https://www.mathplan.de/moses/xsd/default", propOrder = {
    "ignore",
    "ignoreIfSet",
    "id"
})
@XmlSeeAlso({
    MNamedEntity.class
})
public class MBaseEntity {

    @XmlElement(namespace = "https://www.mathplan.de/moses/xsd/default")
    protected List<String> ignore;
    @XmlElement(namespace = "https://www.mathplan.de/moses/xsd/default")
    protected List<String> ignoreIfSet;
    @XmlElement(namespace = "https://www.mathplan.de/moses/xsd/default", required = true)
    protected String id;

    /**
     * Gets the value of the ignore property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ignore property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIgnore().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getIgnore() {
        if (ignore == null) {
            ignore = new ArrayList<String>();
        }
        return this.ignore;
    }

    /**
     * Gets the value of the ignoreIfSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ignoreIfSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIgnoreIfSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getIgnoreIfSet() {
        if (ignoreIfSet == null) {
            ignoreIfSet = new ArrayList<String>();
        }
        return this.ignoreIfSet;
    }

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
