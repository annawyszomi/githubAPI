package com.githubAPI.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

import lombok.Data;

@Data
public class User {
    private long id;
    private String login;
    private String name;
    private String type;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    @JsonProperty("created_at")
    private Date createdAt;

    private int followers;

    @JsonProperty("public_repos")
    private int publicRepos;

}
