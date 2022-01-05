package com.bechtle.eagl.webapp.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.converter.RsaKeyConverters;
import org.springframework.security.saml2.core.Saml2X509Credential;
import org.springframework.security.saml2.provider.service.registration.InMemoryRelyingPartyRegistrationRepository;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistration;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistrationRepository;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistrations;

import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateKey;

@Configuration
@Slf4j
@Profile("local")
public class LocalRelyingPartyConfiguration {


    @Value("${locations.metadata.okta_localhost}")
    String okta_metadata_localhost;

    @Value("${locations.certificates.signing}")
    String cert_path_signing;

    @Value("${locations.certificates.decryption}")
    String cert_path_decryption;
    
    @Value("${locations.key}")
    String key_path;


    @Bean
    public RelyingPartyRegistrationRepository relyingPartyRegistrations() throws CertificateException, IOException {

        RelyingPartyRegistration okta_local = RelyingPartyRegistrations
                .fromMetadataLocation(okta_metadata_localhost)
                .registrationId("okta_localhost")
                .build();
        return new InMemoryRelyingPartyRegistrationRepository(okta_local);
    }



}