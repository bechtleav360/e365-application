package com.bechtle.eagl.webapp.services;

import com.bechtle.eagl.webapp.model.Relationships;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.security.saml2.provider.service.authentication.Saml2Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Clean solution would be session-scoped bean, but they are bit complicated for now.
 */
@Component
public class AuthenticationAttributes {

    private final Map<String, String> walletMappings = new HashMap<>();
    private final Map<String, Set<Flag>> flags = new HashMap<>();

    public enum Flag {
            AUTHENICATION_EVENT_CONSUMED
    }

    @Autowired
    private Environment env;

    public String getEMail(Saml2AuthenticatedPrincipal principal) {
        return this.getValue(principal, "email");
    }

    public String getUid(Saml2AuthenticatedPrincipal principal) {
        return this.getValue(principal, "uid");
    }

    public String getUid(Saml2Authentication auth) {
        return this.getUid((Saml2AuthenticatedPrincipal) auth.getPrincipal());
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

    public Set<Flag> getFlags(Saml2AuthenticatedPrincipal principal) {
        if(! this.flags.containsKey(this.getUid(principal))) {
            this.flags.put(this.getUid(principal), new HashSet<>(Flag.values().length));
        }
        return this.flags.get(this.getUid(principal));
    }

    public boolean hasFlag(Saml2AuthenticatedPrincipal principal, Flag flag) {
        return getFlags(principal).stream().findFirst().isPresent();
    }

    public void setFlag(Saml2AuthenticatedPrincipal principal, Flag flag) {
        getFlags(principal).add(flag);
    }

    public void unsetFlag(Saml2AuthenticatedPrincipal principal, Flag flag) {
        getFlags(principal).remove(flag);
    }
}
