package com.bechtle.eagl.webapp.clients;

import com.bechtle.eagl.webapp.clients.user.requests.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Service
@Slf4j
public class UsersClient extends AbstractClient {

    @Value("${endpoints.user.url}")
    String url;

    @Value("${endpoints.user.apiKey}")
    String apiKey;






    public boolean checkUser(String username) throws IOException {
        ResponseEntity<User> response = getRestTemplate().getForEntity(url + "/" + username, User.class);
        if(response.getStatusCode().value() == 404) return false;
        if(response.getBody() == null) return false;
        if(StringUtils.hasLength(response.getBody().getLogin())) return true;

        else throw new IOException("Failed to retrieve user from wallet api, response is: "+response.getStatusCode());

    }

    public User createUser(String username) throws IOException {
        HttpEntity<User> request = new HttpEntity<>(User.builder().login(username).build());
        ResponseEntity<User> response = getRestTemplate().exchange(url + "/", HttpMethod.POST, request, User.class);
        if(response.getStatusCode().is5xxServerError() || response.getStatusCode().is4xxClientError()) {
            throw new IOException("Failed to create user through wallet api, response is: "+response.getStatusCode());
        }
        return response.getBody();
    }
}
