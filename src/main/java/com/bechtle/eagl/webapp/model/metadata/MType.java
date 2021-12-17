//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2021.12.16 um 04:58:56 PM CET 
//


package com.bechtle.eagl.webapp.model.metadata;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für MType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="MType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="bird_academy"/&gt;
 *     &lt;enumeration value="bird_program"/&gt;
 *     &lt;enumeration value="bird_module"/&gt;
 *     &lt;enumeration value="bird_course"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "MType", namespace = "https://www.mathplan.de/moses/xsd/default")
@XmlEnum
public enum MType {

    @XmlEnumValue("bird_academy")
    BIRD_ACADEMY("bird_academy"),
    @XmlEnumValue("bird_program")
    BIRD_PROGRAM("bird_program"),
    @XmlEnumValue("bird_module")
    BIRD_MODULE("bird_module"),
    @XmlEnumValue("bird_course")
    BIRD_COURSE("bird_course");
    private final String value;

    MType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MType fromValue(String v) {
        for (MType c: MType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
