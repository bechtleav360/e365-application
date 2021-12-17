//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2021.12.16 um 04:58:56 PM CET 
//


package com.bechtle.eagl.webapp.model.metadata;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.bechtle.eagl.webapp.model.metadata package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.bechtle.eagl.webapp.model.metadata
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Import }
     * 
     */
    public Import createImport() {
        return new Import();
    }

    /**
     * Create an instance of {@link MList }
     * 
     */
    public MList createMList() {
        return new MList();
    }

    /**
     * Create an instance of {@link MBaseEntity }
     * 
     */
    public MBaseEntity createMBaseEntity() {
        return new MBaseEntity();
    }

    /**
     * Create an instance of {@link MNamedEntity }
     * 
     */
    public MNamedEntity createMNamedEntity() {
        return new MNamedEntity();
    }

    /**
     * Create an instance of {@link MBirdAcademy }
     * 
     */
    public MBirdAcademy createMBirdAcademy() {
        return new MBirdAcademy();
    }

    /**
     * Create an instance of {@link MBirdProgram }
     * 
     */
    public MBirdProgram createMBirdProgram() {
        return new MBirdProgram();
    }

    /**
     * Create an instance of {@link MBirdModule }
     * 
     */
    public MBirdModule createMBirdModule() {
        return new MBirdModule();
    }

    /**
     * Create an instance of {@link MBirdCourse }
     * 
     */
    public MBirdCourse createMBirdCourse() {
        return new MBirdCourse();
    }

}
