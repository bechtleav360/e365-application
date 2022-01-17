package com.bechtle.eagl.webapp.model.metadata;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
@JacksonXmlRootElement(namespace = "https://www.mathplan.de/moses/xsd/default", localName = "import")
public class MImport {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "list", namespace = "https://www.mathplan.de/moses/xsd/default")
    @Singular("entity")
    List<MList> list;


}
