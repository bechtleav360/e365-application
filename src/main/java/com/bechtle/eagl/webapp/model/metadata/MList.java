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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für MList complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="MList"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="bird_academy" type="{https://www.mathplan.de/moses/xsd/default}MBirdAcademy" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="bird_program" type="{https://www.mathplan.de/moses/xsd/default}MBirdProgram" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="bird_module" type="{https://www.mathplan.de/moses/xsd/default}MBirdModule" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="bird_course" type="{https://www.mathplan.de/moses/xsd/default}MBirdCourse" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute name="type" use="required" type="{https://www.mathplan.de/moses/xsd/default}MType" /&gt;
 *       &lt;attribute name="context" type="{https://www.mathplan.de/moses/xsd/default}MContext" /&gt;
 *       &lt;attribute name="mode" type="{https://www.mathplan.de/moses/xsd/default}MMode" /&gt;
 *       &lt;attribute name="semesterFilter" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="order" type="{https://www.mathplan.de/moses/xsd/default}ordertype" default="1000" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MList", namespace = "https://www.mathplan.de/moses/xsd/default", propOrder = {
    "birdAcademy",
    "birdProgram",
    "birdModule",
    "birdCourse"
})
public class MList {

    @XmlElement(name = "bird_academy", namespace = "https://www.mathplan.de/moses/xsd/default")
    protected List<MBirdAcademy> birdAcademy;
    @XmlElement(name = "bird_program", namespace = "https://www.mathplan.de/moses/xsd/default")
    protected List<MBirdProgram> birdProgram;
    @XmlElement(name = "bird_module", namespace = "https://www.mathplan.de/moses/xsd/default")
    protected List<MBirdModule> birdModule;
    @XmlElement(name = "bird_course", namespace = "https://www.mathplan.de/moses/xsd/default")
    protected List<MBirdCourse> birdCourse;
    @XmlAttribute(name = "type", required = true)
    protected MType type;
    @XmlAttribute(name = "context")
    protected String context;
    @XmlAttribute(name = "mode")
    protected MMode mode;
    @XmlAttribute(name = "semesterFilter")
    protected String semesterFilter;
    @XmlAttribute(name = "order")
    protected String order;

    /**
     * Gets the value of the birdAcademy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the birdAcademy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBirdAcademy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MBirdAcademy }
     * 
     * 
     */
    public List<MBirdAcademy> getBirdAcademy() {
        if (birdAcademy == null) {
            birdAcademy = new ArrayList<MBirdAcademy>();
        }
        return this.birdAcademy;
    }

    /**
     * Gets the value of the birdProgram property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the birdProgram property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBirdProgram().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MBirdProgram }
     * 
     * 
     */
    public List<MBirdProgram> getBirdProgram() {
        if (birdProgram == null) {
            birdProgram = new ArrayList<MBirdProgram>();
        }
        return this.birdProgram;
    }

    /**
     * Gets the value of the birdModule property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the birdModule property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBirdModule().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MBirdModule }
     * 
     * 
     */
    public List<MBirdModule> getBirdModule() {
        if (birdModule == null) {
            birdModule = new ArrayList<MBirdModule>();
        }
        return this.birdModule;
    }

    /**
     * Gets the value of the birdCourse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the birdCourse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBirdCourse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MBirdCourse }
     * 
     * 
     */
    public List<MBirdCourse> getBirdCourse() {
        if (birdCourse == null) {
            birdCourse = new ArrayList<MBirdCourse>();
        }
        return this.birdCourse;
    }

    /**
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MType }
     *     
     */
    public MType getType() {
        return type;
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MType }
     *     
     */
    public void setType(MType value) {
        this.type = value;
    }

    /**
     * Ruft den Wert der context-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContext() {
        return context;
    }

    /**
     * Legt den Wert der context-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContext(String value) {
        this.context = value;
    }

    /**
     * Ruft den Wert der mode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MMode }
     *     
     */
    public MMode getMode() {
        return mode;
    }

    /**
     * Legt den Wert der mode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MMode }
     *     
     */
    public void setMode(MMode value) {
        this.mode = value;
    }

    /**
     * Ruft den Wert der semesterFilter-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSemesterFilter() {
        return semesterFilter;
    }

    /**
     * Legt den Wert der semesterFilter-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSemesterFilter(String value) {
        this.semesterFilter = value;
    }

    /**
     * Ruft den Wert der order-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrder() {
        if (order == null) {
            return "1000";
        } else {
            return order;
        }
    }

    /**
     * Legt den Wert der order-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrder(String value) {
        this.order = value;
    }

}
