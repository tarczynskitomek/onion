package it.tarczynski.onion.user.model;

import it.tarczynski.onion.user.policy.UserEmailPolicy;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Builder(access = AccessLevel.PACKAGE)
@Getter(AccessLevel.NONE)
public class User {
    private Integer id;
    private String name;
    private String email;

    public void changeEmail(String newEmail, UserEmailPolicy userEmailPolicy) {
        userEmailPolicy.verifyEmail(newEmail);
        this.email = newEmail;
    }
}
