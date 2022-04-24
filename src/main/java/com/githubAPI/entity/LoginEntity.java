package com.githubAPI.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "login")
@NoArgsConstructor
public class LoginEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String login;

  @Column(name = "request_count")
  private int requestCount;

  public LoginEntity(String login, int requestCount) {
    this.login = login;
    this.requestCount = requestCount;
  }
}
