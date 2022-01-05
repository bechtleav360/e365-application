package com.bechtle.eagl.webapp.clients;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class WalletClient {

    @Value("${endpoints.wallet.url}")
    String url;

    @Value("${endpoints.wallet.apiKey}")
    String apiKey;

    private final RestTemplate restTemplate;

    public WalletClient() {

        /**
         * We are forced to use RestTemplate, since we are not allowed to have Webflux in our dependencies. Saml is not
         * supported in the reactive security stack.
         */
        restTemplate = new RestTemplate();

    }

    private HttpHeaders getApiKeyHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-API-KEY", apiKey);
        return headers;
    }

    public byte[] getTokenImage() {
        HttpEntity<byte[]> request = new HttpEntity<>(getApiKeyHeader());
        ResponseEntity<byte[]> response = restTemplate.exchange(url + "/mappings/token", HttpMethod.GET, request, byte[].class);
        return response.getBody();
    }


}
