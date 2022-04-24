package com.githubAPI.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.githubAPI.domain.User
import com.githubAPI.domain.UserResponse
import com.githubAPI.entity.LoginEntity
import com.githubAPI.service.ApiResponder
import com.githubAPI.service.LoginService
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import spock.lang.Specification

@WebMvcTest(controllers = [UserController])
class UserControllerTest extends Specification {

    @Autowired
    MockMvc mockMvc

    @Autowired
    ObjectMapper objectMapper

    @SpringBean
    ApiResponder responder = Mock()

    @SpringBean
    LoginService loginService = Mock()


    def 'should return user response'() {
        given:
        loginService.updateRequestCount(_ as String) >> new LoginEntity()
        responder.getUser(_ as String) >> new User(login: 'vvv')

        when:
        def response = mockMvc.perform(MockMvcRequestBuilders.get("/users/vvv")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse()

        def userResponse = objectMapper.readValue(response.getContentAsByteArray(), UserResponse)

        then:
        userResponse.login == 'vvv'

    }
}
