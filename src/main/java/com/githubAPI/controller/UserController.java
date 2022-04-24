package com.githubAPI.controller;

import com.githubAPI.domain.User;
import com.githubAPI.domain.UserResponse;
import com.githubAPI.service.ApiResponder;
import com.githubAPI.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final ApiResponder responder;
    private final LoginService loginService;

    @GetMapping("/users/{login}")
    @ResponseBody
    public ResponseEntity<UserResponse> getUser(@PathVariable String login) {

        User user = responder.getUser(login);
        if (user == null) {
            return ResponseEntity.notFound().build();
        } else {
            UserResponse userResponse = new UserResponse(user);
            loginService.updateRequestCount(login);
            return ResponseEntity.ok(userResponse);
        }
    }

}
