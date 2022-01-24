package com.bechtle.eagl.webapp.consumer;

import com.bechtle.eagl.webapp.clients.UsersClient;
import com.bechtle.eagl.webapp.model.User;
import com.bechtle.eagl.webapp.model.events.RetryingAuthenticationEvent;
import com.bechtle.eagl.webapp.model.events.UserRefreshedEvent;
import com.bechtle.eagl.webapp.services.AuthenticationAttributes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpServerErrorException;

import javax.swing.text.rtf.RTFEditorKit;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

@Service
@Slf4j
public class UserEvents {

    @Value("${endpoints.user.retries}")
    private int maxRetries;

    private UsersClient client;
    private final AuthenticationAttributes authenticationAttributes;
    private final TaskScheduler scheduler;
    private final ApplicationEventPublisher publisher;

    public UserEvents(@Autowired UsersClient client,
                      @Autowired AuthenticationAttributes authenticationAttributes,
                      @Autowired TaskScheduler scheduler, ApplicationEventPublisher publisher) {

        this.client = client;
        this.authenticationAttributes = authenticationAttributes;
        this.scheduler = scheduler;
        this.publisher = publisher;
    }


    @EventListener({RetryingAuthenticationEvent.class})
    public void handleRetryingEvent(RetryingAuthenticationEvent event) {
        if (event.getRetry() >= maxRetries) {
            log.error("Max retries exceeded, skipping creation of user with id {}", authenticationAttributes.getUid((Saml2AuthenticatedPrincipal) event.getAuthentication().getPrincipal()));
        } else {
            if(event.hasRetries()) {
                log.debug("Retrying (attempt '{}') creation of user with id {}", event.getRetry(), authenticationAttributes.getUid((Saml2AuthenticatedPrincipal) event.getAuthentication().getPrincipal()));
                scheduler.schedule(() -> this.checkIfUserExists(event), Instant.now().plusSeconds(5));
            } else {
                scheduler.schedule(() -> this.checkIfUserExists(event), Instant.now().plusMillis(10));
            }
        }

    }


    @EventListener({AuthenticationSuccessEvent.class, InteractiveAuthenticationSuccessEvent.class})
    public RetryingAuthenticationEvent handleEvent(AbstractAuthenticationEvent event) {
        log.trace("New authentication event received of type: "+event.getClass().getSimpleName());
        if (!(event.getAuthentication().getPrincipal() instanceof Saml2AuthenticatedPrincipal)) {
            log.warn("Invalid authentication detected: {}", event.getAuthentication());
            return null;
        }

        if(this.authenticationAttributes.hasFlag((Saml2AuthenticatedPrincipal) event.getAuthentication().getPrincipal(), AuthenticationAttributes.Flag.AUTHENICATION_EVENT_CONSUMED)) {
            log.trace("Skip authentication event, since it is already consumed: {}", event.getAuthentication());
            return null;
        }

        return new RetryingAuthenticationEvent(event);
    }


    private void checkIfUserExists(RetryingAuthenticationEvent event) {

        // InteractiveAuthenticationSuccessEvent is thrown all the time, we have to ignore any which has been handled already (part of authenticationAttributes)
        Saml2AuthenticatedPrincipal principal = (Saml2AuthenticatedPrincipal) event.getAuthentication().getPrincipal();
        String login = authenticationAttributes.getUid(principal);
        this.authenticationAttributes.setFlag(principal, AuthenticationAttributes.Flag.AUTHENICATION_EVENT_CONSUMED);

        if (!StringUtils.hasLength(login)) {
            log.warn("No username in authentication detected: {}", login);
            return;
        }
        log.debug("New user '{}' authenticated, checking if user exists or has to be created.", login);



        try {
            User user = client.getUser(login);

            if(user == null) {
                log.info("User '{}' does not exist, creating a new user", login);
                client.createUser(login);
            } else {
                log.trace("User '{}' exists", login);
                user.getRelationships().stream().findFirst()
                        .map(relationships -> {
                            authenticationAttributes.setWalletId((Saml2AuthenticatedPrincipal) principal, relationships);
                            return relationships;
                        });
            }
        } catch (HttpServerErrorException ex) {
            // we pool the request
            event.incrementRetries();
            publisher.publishEvent(event);

        } catch (IOException e) {
            log.warn("Failed to check authenticated user.", e);
        }
    }

    /**
     * Whenever we query the graph for user data, we check if any of the user details are in the current session data
     */
    @EventListener(UserRefreshedEvent.class)
    public void syncUserWithPrincipal(UserRefreshedEvent userRefreshedEvent) {
        User user = userRefreshedEvent.getUser();
    }


}
