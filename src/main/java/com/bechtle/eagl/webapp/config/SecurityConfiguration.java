package com.bechtle.eagl.webapp.config;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.converter.RsaKeyConverters;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.saml2.core.Saml2X509Credential;
import org.springframework.security.saml2.provider.service.metadata.OpenSamlMetadataResolver;
import org.springframework.security.saml2.provider.service.metadata.Saml2MetadataResolver;
import org.springframework.security.saml2.provider.service.registration.InMemoryRelyingPartyRegistrationRepository;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistration;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistrationRepository;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistrations;
import org.springframework.security.saml2.provider.service.servlet.filter.Saml2WebSsoAuthenticationFilter;
import org.springframework.security.saml2.provider.service.web.DefaultRelyingPartyRegistrationResolver;
import org.springframework.security.saml2.provider.service.web.RelyingPartyRegistrationResolver;
import org.springframework.security.saml2.provider.service.web.Saml2AuthenticationTokenConverter;
import org.springframework.security.saml2.provider.service.web.Saml2MetadataFilter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

import javax.servlet.http.HttpServletRequest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@Slf4j
public class SecurityConfiguration {


    @Value("${locations.metadata.okta_azure}")
    String okta_metadata;
    @Value("${locations.metadata.okta_localhost}")
    String okta_metadata_localhost;

    @Value("${locations.certificates.signing}")
    String cert_path_signing;
    @Value("${locations.certificates.decryption}")
    String cert_path_decryption;
    @Value("${locations.key}")
    String key_path;


    @Bean
    SecurityFilterChain configureSaml(HttpSecurity http, RelyingPartyRegistrationRepository relyingPartyRegistrationRepository) throws Exception {
        http
                .csrf().disable() // required for okta
                .authorizeHttpRequests((authorize) -> authorize
                        .mvcMatchers("/user/**").authenticated()
                        .mvcMatchers("/saml2/**").permitAll()
                        .mvcMatchers("/metadata/**").permitAll()
                        .anyRequest().permitAll()
                )
                .saml2Login(withDefaults())
                .saml2Logout(withDefaults());
        // @formatter:on

        // add auto-generation of ServiceProvider Metadata
        // access through http://localhost:8090/saml2/service-provider-metadata/{reg-id}}
        RelyingPartyRegistrationResolver relyingPartyRegistrationResolver =
                new DefaultRelyingPartyRegistrationResolver(relyingPartyRegistrationRepository);
        Saml2MetadataFilter filter = new Saml2MetadataFilter(relyingPartyRegistrationResolver, new OpenSamlMetadataResolver());
        http.addFilterBefore(filter, Saml2WebSsoAuthenticationFilter.class);

        return http.build();
    }


    @Bean
    public RelyingPartyRegistrationRepository relyingPartyRegistrations() throws CertificateException, IOException {



        RelyingPartyRegistration okta = RelyingPartyRegistrations
                .fromMetadataLocation(okta_metadata)
                .registrationId("okta")
                .signingX509Credentials(consumer -> {
                    Saml2X509Credential cert = Saml2X509Credential.signing(this.loadPrivateKey(), this.loadCertificate(cert_path_signing));
                    consumer.add(cert);
                })
                .decryptionX509Credentials(consumer -> {
                    Saml2X509Credential cert = Saml2X509Credential.decryption(this.loadPrivateKey(), this.loadCertificate(cert_path_decryption));
                    consumer.add(cert);
                })
                .build();

        RelyingPartyRegistration okta_local = RelyingPartyRegistrations
                .fromMetadataLocation(okta_metadata_localhost)
                .registrationId("okta_localhost")
                .signingX509Credentials(consumer -> {
                    Saml2X509Credential cert = Saml2X509Credential.signing(this.loadPrivateKey(), this.loadCertificate(cert_path_signing));
                    consumer.add(cert);
                })
                .decryptionX509Credentials(consumer -> {
                    Saml2X509Credential cert = Saml2X509Credential.decryption(this.loadPrivateKey(), this.loadCertificate(cert_path_decryption));
                    consumer.add(cert);
                })
                .build();

        RelyingPartyRegistration daad = RelyingPartyRegistrations
                .fromMetadataLocation("https://saml-bird.daad.com/saml2/idp/metadata.php")
                .registrationId("daad")
                .signingX509Credentials(consumer -> {
                    Saml2X509Credential cert = Saml2X509Credential.signing(this.loadPrivateKey(), this.loadCertificate(cert_path_signing));
                    consumer.add(cert);
                })
                .decryptionX509Credentials(consumer -> {
                    Saml2X509Credential cert = Saml2X509Credential.decryption(this.loadPrivateKey(), this.loadCertificate(cert_path_decryption));
                    consumer.add(cert);
                })
                .build();
        return new InMemoryRelyingPartyRegistrationRepository(okta, okta_local, daad);
    }


    private X509Certificate loadCertificate(String path)  {
        Resource resource = new ClassPathResource(path);
        try (InputStream is = resource.getInputStream()) {
            X509Certificate certificate = (X509Certificate)
                    CertificateFactory.getInstance("X.509").generateCertificate(is);
            return certificate;
        } catch (IOException e) {
            log.error("Failed to load certificate in path '{}'", path);
            throw new IllegalArgumentException("Invalid path to certificate", e);
        } catch (CertificateException e) {
            log.error("Failed to parse certificate in path '{}'", path);
            throw new IllegalArgumentException("Invalid certificate", e);
        }
    }

    private RSAPrivateKey loadPrivateKey() throws IllegalArgumentException {
        Resource resource = new ClassPathResource(key_path);
        try (InputStream is = resource.getInputStream()) {
            RSAPrivateKey rsa = RsaKeyConverters.pkcs8().convert(is);
            return rsa;
        } catch (IOException e) {
            log.error("Failed to load private key");
            throw new IllegalArgumentException("Invalid path to private key", e);
        }
    }


}