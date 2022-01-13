package com.bechtle.eagl.webapp.services;

import com.bechtle.eagl.webapp.model.Relationships;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Clean solution would be session-scoped bean, but they are bit complicated for now.
 */
@Component
public class AuthenticationAttributes {

    private final Map<String, String> walletMappings = new HashMap<>();

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

    public void setWalletId(Saml2AuthenticatedPrincipal principal, Relationships relationships) {

        if(StringUtils.hasLength(relationships.getRelationshipId()))
            this.walletMappings.put(this.getUid(principal), relationships.getRelationshipId());

    }

    public String getWalletId(Saml2AuthenticatedPrincipal principal) {
        return this.walletMappings.get(this.getUid(principal));
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
