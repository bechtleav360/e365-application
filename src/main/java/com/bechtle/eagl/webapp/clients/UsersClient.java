package com.bechtle.eagl.webapp.clients;

import com.bechtle.eagl.webapp.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

@Service
@Slf4j
public class UsersClient extends AbstractClient {

    @Value("${endpoints.user.url}")
    String url;

    @Value("${endpoints.user.apikey}")
    String apiKey;






    public User getUser(String username) throws IOException {
        String uri = UriComponentsBuilder.fromHttpUrl(url).pathSegment(username).encode().toUriString();
        HttpEntity<String> request = new HttpEntity<>(getApiKeyHeader(apiKey));
        try {
            ResponseEntity<User> response = getRestTemplate().exchange(uri, HttpMethod.GET, request, User.class);
            if(response.getStatusCode().value() == 404) return null;
            if(response.getBody() == null) return null;
            if(StringUtils.hasLength(response.getBody().getLogin())) {
                return response.getBody();
            }

            else {
                log.error("Failed to retrieve user {} with status code {}", username, response.getStatusCodeValue());
                throw new IOException("Failed to retrieve user from wallet api with status "+response.getStatusCodeValue());
            }
        } catch (HttpClientErrorException ex) {
            if(ex.getStatusCode() == HttpStatus.NOT_FOUND) return null;
            else throw new IOException("Failed to retrieve user from wallet api", ex);

        } catch (HttpServerErrorException ex) {
            log.error("Failed to retrieve user {}", username, ex);
            throw new IOException("Failed to retrieve user from wallet api", ex);
        }

    }

    public User createUser(String username) throws IOException {
        // Lombok Builder seems to be not supported jackson (-webflux) environment
        HttpHeaders headers = getApiKeyHeader(apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        User user = new User();
        user.setLogin(username);

        HttpEntity<User> request = new HttpEntity<>(user, headers);
        ResponseEntity<User> response = getRestTemplate().exchange(url + "/", HttpMethod.POST, request, User.class);
        if(response.getStatusCode().is5xxServerError() || response.getStatusCode().is4xxClientError()) {
            throw new IOException("Failed to create user through wallet api, response is: "+response.getStatusCode());
        }
        return response.getBody();
    }
}
