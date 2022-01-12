package com.bechtle.eagl.webapp.clients;

import com.bechtle.eagl.webapp.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

@Service
@Slf4j
public class UsersClient extends AbstractClient {

    @Value("${endpoints.user.url}")
    String url;

    @Value("${endpoints.user.apiKey}")
    String apiKey;






    public User getUser(String username) throws IOException {
        String uri = UriComponentsBuilder.fromHttpUrl(url).pathSegment(username).encode().toUriString();
        HttpEntity<String> request = new HttpEntity<>(getApiKeyHeader(apiKey));

        ResponseEntity<User> response = getRestTemplate().exchange(uri, HttpMethod.GET, request, User.class);
        if(response.getStatusCode().value() == 404) return null;
        if(response.getBody() == null) return null;
        if(StringUtils.hasLength(response.getBody().getLogin())) {

            return response.getBody();
        }

        else throw new IOException("Failed to retrieve user from wallet api, response is: "+response.getStatusCode());

    }

    public User createUser(String username) throws IOException {
        // Lombok Builder seems to be not supported jackson (-webflux) environment
        User user = new User();
        user.setLogin(username);

        HttpEntity<User> request = new HttpEntity<>(user, getApiKeyHeader(apiKey));
        ResponseEntity<User> response = getRestTemplate().exchange(url + "/", HttpMethod.POST, request, User.class);
        if(response.getStatusCode().is5xxServerError() || response.getStatusCode().is4xxClientError()) {
            throw new IOException("Failed to create user through wallet api, response is: "+response.getStatusCode());
        }
        return response.getBody();
    }
}
