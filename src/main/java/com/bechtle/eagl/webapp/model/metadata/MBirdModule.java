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
 * <p>Java-Klasse für MBirdModule complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="MBirdModule"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://www.mathplan.de/moses/xsd/default}MNamedEntity"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="academyId" type="{https://www.mathplan.de/moses/xsd/default}MId"/&gt;
 *         &lt;element name="examtitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="subjectExamtitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="duration" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="credits" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="workload" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="requirements" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="learningOutcomes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="recommendedKnowledge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="moduleContent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="formOfWork" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "MBirdModule", namespace = "https://www.mathplan.de/moses/xsd/default", propOrder = {
    "academyId",
    "examtitle",
    "subjectExamtitle",
    "duration",
    "credits",
    "workload",
    "requirements",
    "learningOutcomes",
    "recommendedKnowledge",
    "moduleContent",
    "formOfWork",
    "birdCourseId"
})
public class MBirdModule
    extends MNamedEntity
{

    @XmlElement(namespace = "https://www.mathplan.de/moses/xsd/default", required = true)
    protected String academyId;
    @XmlElement(namespace = "https://www.mathplan.de/moses/xsd/default")
    protected String examtitle;
    @XmlElement(namespace = "https://www.mathplan.de/moses/xsd/default")
    protected String subjectExamtitle;
    @XmlElement(namespace = "https://www.mathplan.de/moses/xsd/default")
    protected BigInteger duration;
    @XmlElement(namespace = "https://www.mathplan.de/moses/xsd/default")
    protected BigInteger credits;
    @XmlElement(namespace = "https://www.mathplan.de/moses/xsd/default")
    protected String workload;
    @XmlElement(namespace = "https://www.mathplan.de/moses/xsd/default")
    protected String requirements;
    @XmlElement(namespace = "https://www.mathplan.de/moses/xsd/default")
    protected String learningOutcomes;
    @XmlElement(namespace = "https://www.mathplan.de/moses/xsd/default")
    protected String recommendedKnowledge;
    @XmlElement(namespace = "https://www.mathplan.de/moses/xsd/default")
    protected String moduleContent;
    @XmlElement(namespace = "https://www.mathplan.de/moses/xsd/default")
    protected String formOfWork;
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
     * Ruft den Wert der examtitle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExamtitle() {
        return examtitle;
    }

    /**
     * Legt den Wert der examtitle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExamtitle(String value) {
        this.examtitle = value;
    }

    /**
     * Ruft den Wert der subjectExamtitle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubjectExamtitle() {
        return subjectExamtitle;
    }

    /**
     * Legt den Wert der subjectExamtitle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubjectExamtitle(String value) {
        this.subjectExamtitle = value;
    }

    /**
     * Ruft den Wert der duration-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDuration() {
        return duration;
    }

    /**
     * Legt den Wert der duration-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDuration(BigInteger value) {
        this.duration = value;
    }

    /**
     * Ruft den Wert der credits-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCredits() {
        return credits;
    }

    /**
     * Legt den Wert der credits-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCredits(BigInteger value) {
        this.credits = value;
    }

    /**
     * Ruft den Wert der workload-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkload() {
        return workload;
    }

    /**
     * Legt den Wert der workload-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkload(String value) {
        this.workload = value;
    }

    /**
     * Ruft den Wert der requirements-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequirements() {
        return requirements;
    }

    /**
     * Legt den Wert der requirements-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequirements(String value) {
        this.requirements = value;
    }

    /**
     * Ruft den Wert der learningOutcomes-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLearningOutcomes() {
        return learningOutcomes;
    }

    /**
     * Legt den Wert der learningOutcomes-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLearningOutcomes(String value) {
        this.learningOutcomes = value;
    }

    /**
     * Ruft den Wert der recommendedKnowledge-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecommendedKnowledge() {
        return recommendedKnowledge;
    }

    /**
     * Legt den Wert der recommendedKnowledge-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecommendedKnowledge(String value) {
        this.recommendedKnowledge = value;
    }

    /**
     * Ruft den Wert der moduleContent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModuleContent() {
        return moduleContent;
    }

    /**
     * Legt den Wert der moduleContent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModuleContent(String value) {
        this.moduleContent = value;
    }

    /**
     * Ruft den Wert der formOfWork-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormOfWork() {
        return formOfWork;
    }

    /**
     * Legt den Wert der formOfWork-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormOfWork(String value) {
        this.formOfWork = value;
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
