package com.bechtle.eagl.webapp.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.saml2.provider.service.metadata.OpenSamlMetadataResolver;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistrationRepository;
import org.springframework.security.saml2.provider.service.servlet.filter.Saml2WebSsoAuthenticationFilter;
import org.springframework.security.saml2.provider.service.web.DefaultRelyingPartyRegistrationResolver;
import org.springframework.security.saml2.provider.service.web.RelyingPartyRegistrationResolver;
import org.springframework.security.saml2.provider.service.web.Saml2MetadataFilter;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@Slf4j
public class SecurityConfiguration {

    public static final String USER_DETAILS_LOGIN = "username" ;
    public static final String USER_DETAILS_RELATION_ID = "user_details_relationid";
    public static final String USER_DETAILS_CODE = "user_details_code";

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


}