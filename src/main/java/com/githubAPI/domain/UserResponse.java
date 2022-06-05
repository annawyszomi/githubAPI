package com.githubAPI.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class UserResponse {
    private long id;
    private String login;
    private String name;
    private String type;
    private String avatarUrl;
    private Date createdAt;
    private double calculations;

    public UserResponse(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.name = user.getName();
        this.type = user.getType();
        this.avatarUrl = user.getAvatarUrl();
        this.createdAt = user.getCreatedAt();
        this.calculations = getCalculations(user);
    }

    private double getCalculations(User user) {
        if (user == null) {
            return 0;
        }
        var followers = user.getFollowers();
        if (followers == 0) {
            return 0;
        } else {
            return 6.0 / followers * (2 + user.getPublicRepos());
        }
    }

}
