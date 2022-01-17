package com.bechtle.eagl.webapp.model.metadata;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MBirdCourse {

    @JacksonXmlProperty(localName = "id", namespace = "https://www.mathplan.de/moses/xsd/default")
    String id;
    @JacksonXmlProperty(localName = "name", namespace = "https://www.mathplan.de/moses/xsd/default")
    String name;
    @JacksonXmlProperty(localName = "academyId", namespace = "https://www.mathplan.de/moses/xsd/default")
    String academyId;
    @JacksonXmlProperty(localName = "lectureType", namespace = "https://www.mathplan.de/moses/xsd/default")
    String lectureType;

}
