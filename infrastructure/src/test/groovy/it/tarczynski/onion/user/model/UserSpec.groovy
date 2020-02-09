package it.tarczynski.onion.user.model

import it.tarczynski.onion.user.policy.UserEmailPolicy
import spock.lang.Specification

class UserSpec extends Specification {

    UserEmailPolicy emailPolicy = Mock(UserEmailPolicy)

    def 'changeEmail, given already registered email, should throw an exception'() {
        given:
        def user = User.builder().email('email@mail.com')
                .name('name')
                .build()
        emailPolicy.verifyEmail('existing@mail.com') >> {
            throw new IllegalStateException('email in use by another user')
        }

        when:
        user.changeEmail('existing@mail.com', emailPolicy)

        then:
        thrown(IllegalStateException)
    }
}
