package com.bechtle.eagl.webapp.model.events;

import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.core.Authentication;

public class RetryingAuthenticationEvent extends AbstractAuthenticationEvent {
    private int retry = 0;

    public RetryingAuthenticationEvent(AbstractAuthenticationEvent event) {
        super(event.getAuthentication());
        if (event instanceof RetryingAuthenticationEvent) {
            this.retry = ((RetryingAuthenticationEvent) event).getRetry() + 1;
        }
    }


    public int getRetry() {
        return retry;
    }

    public void incrementRetries() {
        this.retry++;
    }

    public boolean hasRetries() {
        return this.retry > 0;
    }
}
