//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2021.12.16 um 04:58:56 PM CET 
//


package com.bechtle.eagl.webapp.model.metadata;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für MBirdProgram complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="MBirdProgram"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://www.mathplan.de/moses/xsd/default}MNamedEntity"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="academyId" type="{https://www.mathplan.de/moses/xsd/default}MId"/&gt;
 *         &lt;element name="degreeName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="startOfProgram" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="typeOfStudies" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="periodOfStudy" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="focusOfStudy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="languageOfStudy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="locationOfStudy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="restrictedApplication" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="applicationRequirements" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="birdModuleId" type="{https://www.mathplan.de/moses/xsd/default}MId" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="birdCourseId" type="{https://www.mathplan.de/moses/xsd/default}MId" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MBirdProgram", namespace = "https://www.mathplan.de/moses/xsd/default", propOrder = {
    "academyId",
    "degreeName",
    "startOfProgram",
    "typeOfStudies",
    "periodOfStudy",
    "focusOfStudy",
    "languageOfStudy",
    "locationOfStudy",
    "restrictedApplication",
    "applicationRequirements",
    "birdModuleId",
    "birdCourseId"
})
public class MBirdProgram
    extends MNamedEntity
{

    @XmlElement(namespace = "https://www.mathplan.de/moses/xsd/default", required = true)
    protected String academyId;
    @XmlElement(namespace = "https://www.mathplan.de/moses/xsd/default", required = true)
    protected String degreeName;
    @XmlElement(namespace = "https://www.mathplan.de/moses/xsd/default")
    protected String startOfProgram;
    @XmlElement(namespace = "https://www.mathplan.de/moses/xsd/default")
    protected String typeOfStudies;
    @XmlElement(namespace = "https://www.mathplan.de/moses/xsd/default")
    protected BigInteger periodOfStudy;
    @XmlElement(namespace = "https://www.mathplan.de/moses/xsd/default")
    protected String focusOfStudy;
    @XmlElement(namespace = "https://www.mathplan.de/moses/xsd/default")
    protected String languageOfStudy;
    @XmlElement(namespace = "https://www.mathplan.de/moses/xsd/default")
    protected String locationOfStudy;
    @XmlElement(namespace = "https://www.mathplan.de/moses/xsd/default")
    protected Boolean restrictedApplication;
    @XmlElement(namespace = "https://www.mathplan.de/moses/xsd/default")
    protected String applicationRequirements;
    @XmlElement(namespace = "https://www.mathplan.de/moses/xsd/default")
    protected List<String> birdModuleId;
    @XmlElement(namespace = "https://www.mathplan.de/moses/xsd/default")
    protected List<String> birdCourseId;

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
     * Ruft den Wert der degreeName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDegreeName() {
        return degreeName;
    }

    /**
     * Legt den Wert der degreeName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDegreeName(String value) {
        this.degreeName = value;
    }

    /**
     * Ruft den Wert der startOfProgram-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartOfProgram() {
        return startOfProgram;
    }

    /**
     * Legt den Wert der startOfProgram-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartOfProgram(String value) {
        this.startOfProgram = value;
    }

    /**
     * Ruft den Wert der typeOfStudies-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeOfStudies() {
        return typeOfStudies;
    }

    /**
     * Legt den Wert der typeOfStudies-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeOfStudies(String value) {
        this.typeOfStudies = value;
    }

    /**
     * Ruft den Wert der periodOfStudy-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPeriodOfStudy() {
        return periodOfStudy;
    }

    /**
     * Legt den Wert der periodOfStudy-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPeriodOfStudy(BigInteger value) {
        this.periodOfStudy = value;
    }

    /**
     * Ruft den Wert der focusOfStudy-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFocusOfStudy() {
        return focusOfStudy;
    }

    /**
     * Legt den Wert der focusOfStudy-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFocusOfStudy(String value) {
        this.focusOfStudy = value;
    }

    /**
     * Ruft den Wert der languageOfStudy-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguageOfStudy() {
        return languageOfStudy;
    }

    /**
     * Legt den Wert der languageOfStudy-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguageOfStudy(String value) {
        this.languageOfStudy = value;
    }

    /**
     * Ruft den Wert der locationOfStudy-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationOfStudy() {
        return locationOfStudy;
    }

    /**
     * Legt den Wert der locationOfStudy-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationOfStudy(String value) {
        this.locationOfStudy = value;
    }

    /**
     * Ruft den Wert der restrictedApplication-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRestrictedApplication() {
        return restrictedApplication;
    }

    /**
     * Legt den Wert der restrictedApplication-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRestrictedApplication(Boolean value) {
        this.restrictedApplication = value;
    }

    /**
     * Ruft den Wert der applicationRequirements-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationRequirements() {
        return applicationRequirements;
    }

    /**
     * Legt den Wert der applicationRequirements-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationRequirements(String value) {
        this.applicationRequirements = value;
    }

    /**
     * Gets the value of the birdModuleId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the birdModuleId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBirdModuleId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getBirdModuleId() {
        if (birdModuleId == null) {
            birdModuleId = new ArrayList<String>();
        }
        return this.birdModuleId;
    }

    /**
     * Gets the value of the birdCourseId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the birdCourseId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBirdCourseId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getBirdCourseId() {
        if (birdCourseId == null) {
            birdCourseId = new ArrayList<String>();
        }
        return this.birdCourseId;
    }

}
