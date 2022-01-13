package com.bechtle.eagl.webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthenticationAttributes {

    @Autowired
    private Environment env;

    public String getEMail(Saml2AuthenticatedPrincipal principal) {
        return this.getValue(principal, "email");
    }

    public String getUid(Saml2AuthenticatedPrincipal principal) {
        return this.getValue(principal, "uid");
    }

    public String getFirstName(Saml2AuthenticatedPrincipal principal) {
        return this.getValue(principal, "firstname");
    }

    public String getLastName(Saml2AuthenticatedPrincipal principal) {
        return this.getValue(principal, "lastname");
    }

    private String getValue(Saml2AuthenticatedPrincipal principal, String key) {
        String path = this.constructPath(principal.getRelyingPartyRegistrationId(), key);
        return principal.getFirstAttribute(env.getProperty(path));
    }

    private String constructPath(String party, String key) {
        return "spring.security.saml2.relyingparty.registration." +
                party +
                ".attributes." +
                key;
    }

}
