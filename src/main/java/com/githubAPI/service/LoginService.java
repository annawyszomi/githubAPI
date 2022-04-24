package com.githubAPI.service;

import com.githubAPI.entity.LoginEntity;
import com.githubAPI.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginRepository repository;

    public LoginEntity updateRequestCount(String login) {

        LoginEntity loginEntity = repository.findByLogin(login)
                .orElseGet(() -> new LoginEntity(login, 0));

        int incrementRequestCount = loginEntity.getRequestCount() + 1;
        loginEntity.setRequestCount(incrementRequestCount);
        return repository.save(loginEntity);
    }
}
