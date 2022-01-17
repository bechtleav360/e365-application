package com.bechtle.eagl.webapp.config;

import com.ctc.wstx.api.WstxOutputProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;

@Configuration
@Slf4j
public class JacksonConfiguration {

    @Bean
    public MappingJackson2XmlHttpMessageConverter getMapper(Jackson2ObjectMapperBuilder builder) {
        log.info("Configuring XML Mapper");
        XmlMapper xmlMapper = builder.createXmlMapper(true).build();
        xmlMapper.enable(ToXmlGenerator.Feature.WRITE_XML_DECLARATION);
        // xmlMapper.getFactory().getXMLOutputFactory().setProperty(WstxOutputProperties.P_USE_DOUBLE_QUOTES_IN_XML_DECL, true);

        // xmlMapper.registerModule(new JaxbAnnotationModule());
        return new MappingJackson2XmlHttpMessageConverter(xmlMapper);
    }


    @Bean
    @Primary // required to serialize actuators as json
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }


}


