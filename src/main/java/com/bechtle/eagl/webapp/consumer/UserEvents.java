package com.bechtle.eagl.webapp.consumer;

import com.bechtle.eagl.webapp.clients.UsersClient;
import com.bechtle.eagl.webapp.model.User;
import com.bechtle.eagl.webapp.config.SecurityConfiguration;
import com.bechtle.eagl.webapp.model.events.UserRefreshedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class UserEvents {

    private UsersClient client;

    public UserEvents(@Autowired UsersClient client) {

        this.client = client;
    }

    @EventListener(AuthenticationSuccessEvent.class)
    public void checkUserExists(AuthenticationSuccessEvent event) {
        Object principal = event.getAuthentication().getPrincipal();
        if (! (principal instanceof Saml2AuthenticatedPrincipal)) {
            log.warn("Invalid authentication detected: {}", event.getAuthentication());
            return;
        }
        Saml2AuthenticatedPrincipal samlPrincipal  = (Saml2AuthenticatedPrincipal) principal;


        List<Object> usernames = samlPrincipal.getAttribute("username");
        if(usernames.size() != 1) {
            log.warn("No username in authentication detected: {}", usernames);
            return;
        }

        String username = usernames.get(0).toString();
        if(! StringUtils.hasLength(username)) {
            log.warn("No username in authentication detected: {}", usernames);
            return;
        }
        log.debug("New user '{}' authenticated, checking if user exists or has to be created.", username);

        try {
            User user = client.getUser(username);

            if(user == null) {
                log.info("User '{}' does not exist, creating a new user", username);
                client.createUser(username);
            } else {
                user.getRelationships().stream().findFirst()
                        .map(relationships -> {
                            samlPrincipal.getAttributes().put(SecurityConfiguration.USER_DETAILS_RELATION_ID, List.of(relationships));
                            return relationships;
                        });
            }
        } catch (IOException e) {
            log.error("Failed to check authenticated user.", e);
        }
    }

    /**
     * Whenever we query the graph for user data, we check if any of the user details are in the current session data
     */
    @EventListener(UserRefreshedEvent.class)
    public void syncUserWithPrincipal(UserRefreshedEvent userRefreshedEvent) {
        User user = userRefreshedEvent.getUser();
    /*
        user.getRelationships().stream().findFirst()
                .map(relationships -> {
                    samlPrincipal.getAttributes().put(SecurityConfiguration.USER_DETAILS_RELATION_ID, List.of(relationships));
                    return relationships;
                });*/
    }


}
