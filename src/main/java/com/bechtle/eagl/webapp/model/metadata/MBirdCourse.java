//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2021.12.16 um 04:58:56 PM CET 
//


package com.bechtle.eagl.webapp.model.metadata;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für MBirdCourse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="MBirdCourse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://www.mathplan.de/moses/xsd/default}MNamedEntity"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="academyId" type="{https://www.mathplan.de/moses/xsd/default}MId"/&gt;
 *         &lt;element name="lectureType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="sws" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="department" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MBirdCourse", namespace = "https://www.mathplan.de/moses/xsd/default", propOrder = {
    "academyId",
    "lectureType",
    "sws",
    "department"
})
public class MBirdCourse
    extends MNamedEntity
{

    @XmlElement(namespace = "https://www.mathplan.de/moses/xsd/default", required = true)
    protected String academyId;
    @XmlElement(namespace = "https://www.mathplan.de/moses/xsd/default", required = true)
    protected String lectureType;
    @XmlElement(namespace = "https://www.mathplan.de/moses/xsd/default")
    protected BigInteger sws;
    @XmlElement(namespace = "https://www.mathplan.de/moses/xsd/default")
    protected String department;

    /**
     * Ruft den Wert der academyId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcademyId() {
        return academyId;
    }

    /**
     * Legt den Wert der academyId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcademyId(String value) {
        this.academyId = value;
    }

    /**
     * Ruft den Wert der lectureType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLectureType() {
        return lectureType;
    }

    /**
     * Legt den Wert der lectureType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLectureType(String value) {
        this.lectureType = value;
    }

    /**
     * Ruft den Wert der sws-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSws() {
        return sws;
    }

    /**
     * Legt den Wert der sws-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSws(BigInteger value) {
        this.sws = value;
    }

    /**
     * Ruft den Wert der department-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Legt den Wert der department-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartment(String value) {
        this.department = value;
    }

}
