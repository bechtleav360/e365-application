package com.bechtle.eagl.webapp.model.metadata;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class MList {

    @JacksonXmlProperty(
            isAttribute = true, localName = "type")
    private String type;

    @JacksonXmlProperty(
            isAttribute = true, namespace = "https://www.mathplan.de/moses/xsd/default", localName = "context")
    private String context;


    @JacksonXmlProperty(
            isAttribute = true, namespace = "https://www.mathplan.de/moses/xsd/default", localName = "mode")
    private String mode;

    @JacksonXmlProperty(
            isAttribute = true, namespace = "https://www.mathplan.de/moses/xsd/default", localName = "semesterFilter")
    private String semesterFilter;

    @JacksonXmlProperty(
            isAttribute = true, namespace = "https://www.mathplan.de/moses/xsd/default", localName = "order")
    private String order;

    @Singular("academy")
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "bird_academy", namespace = "https://www.mathplan.de/moses/xsd/default")
    private List<MBirdAcademy> academies;

    @Singular("course")
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "bird_course", namespace = "https://www.mathplan.de/moses/xsd/default")
    private List<MBirdCourse> courses;

}
