package com.githubAPI.service

import com.blogspot.toomuchcoding.spock.subjcollabs.Collaborator
import com.blogspot.toomuchcoding.spock.subjcollabs.Subject
import com.githubAPI.entity.LoginEntity
import com.githubAPI.repository.LoginRepository
import spock.lang.Specification

class LoginServiceTest extends Specification {

    @Collaborator
    LoginRepository repository = Mock()

    @Subject
    LoginService sut

    def 'should count requests when login exists'() {
        given:
        LoginEntity loginEntity = new LoginEntity()
        loginEntity.requestCount = 3;
        loginEntity.login = "test"
        repository.findByLogin("test") >> Optional.of(loginEntity)

        when:
        sut.updateRequestCount("test");

        then:
        loginEntity.requestCount == 4;

    }

    def 'should return one request when login does not exist'() {
        given:
        LoginEntity loginEntity = new LoginEntity()
        repository.findByLogin(_ as String) >> Optional.of(loginEntity)

        when:
        sut.updateRequestCount(_ as String);

        then:
        loginEntity.requestCount == 1;

    }
}
