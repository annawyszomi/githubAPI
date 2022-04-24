package com.githubAPI.service

import com.blogspot.toomuchcoding.spock.subjcollabs.Collaborator
import com.blogspot.toomuchcoding.spock.subjcollabs.Subject
import com.githubAPI.domain.User
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

class UserServiceTest extends Specification {

    @Collaborator
    RestTemplate restTemplate = Mock()

    @Subject
    ApiResponder sut

    def 'should return user from api'(){
        given:
        restTemplate.getForObject(_, _) >> new User(name: 'kitten')

        when:
        def cat = sut.getUser('cat')

        then:
        noExceptionThrown()
        cat.name == 'kitten'
    }

}
