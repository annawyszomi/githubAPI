package com.githubAPI.service;

import com.githubAPI.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
@RequiredArgsConstructor
public class ApiResponder {

    @Value("${github.users.url:}")
    private  String uriUsers;

    private final RestTemplate restTemplate;

    public User getUser(String login) {

        var url = uriUsers + login;
        User user = null;
        try {
            user = restTemplate.getForObject(url, User.class);
        } catch (RestClientException e) {
            log.error(e.getMessage());
        }
        return user;
    }
}
