package com.bechtle.eagl.webapp.config;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class JacksonConfiguration {

    @Bean
    public XmlMapper getMapper() {
        return  XmlMapper.xmlBuilder().build();

    }
}
