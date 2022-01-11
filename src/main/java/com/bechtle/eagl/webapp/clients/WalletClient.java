package com.bechtle.eagl.webapp.clients;

import com.bechtle.eagl.webapp.clients.user.requests.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
public class WalletClient extends AbstractClient {

    @Value("${endpoints.wallet.url}")
    String url;

    @Value("${endpoints.wallet.apiKey}")
    String apiKey;


    public byte[] getTokenImage(String login) {
        String uri = UriComponentsBuilder.fromHttpUrl(url).pathSegment(login, "token").encode().toUriString();
        HttpEntity<byte[]> request = new HttpEntity<>(getApiKeyHeader(apiKey));
        ResponseEntity<byte[]> response = getRestTemplate().exchange(uri, HttpMethod.GET, request, byte[].class);
        return response.getBody();
    }


    public void sync(String username) {
        String uri = UriComponentsBuilder.fromHttpUrl(url).pathSegment("sync").encode().toUriString();
        HttpEntity<String> request = new HttpEntity<>(getApiKeyHeader(apiKey));
        getRestTemplate().exchange(uri, HttpMethod.GET, request, Void.class);
    }

    public void link(String username, String code) {
        String uri = UriComponentsBuilder.fromHttpUrl(url).pathSegment(username, "code").encode().toUriString();

        HttpEntity<String> request = new HttpEntity<>(code, getApiKeyHeader(apiKey));
        ResponseEntity<User> exchange = getRestTemplate().exchange(uri, HttpMethod.PUT, request, User.class);
        // return exchange.getBody();
    }
}
