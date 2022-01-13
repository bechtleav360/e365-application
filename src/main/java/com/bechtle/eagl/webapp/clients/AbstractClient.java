package com.bechtle.eagl.webapp.clients;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class AbstractClient {

    private final RestTemplate restTemplate;

    protected AbstractClient() {
        /**
         * We are forced to use RestTemplate, since we are not allowed to have Webflux in our dependencies. Saml is not
         * supported in the reactive security stack.
         */
        restTemplate = new RestTemplate();
    }

    protected HttpHeaders getApiKeyHeader(String apiKey) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-API-KEY", apiKey);

        return headers;
    }

    protected RestTemplate getRestTemplate() {
        return this.restTemplate;
    }
}
