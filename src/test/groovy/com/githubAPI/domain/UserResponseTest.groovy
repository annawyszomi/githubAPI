package com.githubAPI.domain

import spock.lang.Specification

class UserResponseTest extends Specification {
    def "should return calculations"() {
        given:
        def user = new User()
        followers = user.followers
        publicRepos = user.publicRepos
        def userResponse = new UserResponse()
        calculations = userResponse.calculations

        where:
        followers | publicRepos | calculations
        5628      | 8      | 0.010660980810234541
        101       | 60     | 3.683168316831683
        96        | 21     | 1.4375

    }
}
