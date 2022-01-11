package com.bechtle.eagl.webapp.consumer;

import com.bechtle.eagl.webapp.clients.UsersClient;
import com.bechtle.eagl.webapp.clients.WalletClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
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

        List<Object> usernames = ((Saml2AuthenticatedPrincipal) principal).getAttribute("username");
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
            if(! client.checkUser(username)) {
                log.info("User '{}' does not exist, creating a new user", username);
                client.createUser(username);
            }
        } catch (IOException e) {
            log.error("Failed to check authenticated user.", e);
        }
    }
}
