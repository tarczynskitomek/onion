package it.tarczynski.onion.user.model;

import it.tarczynski.onion.user.policy.UserEmailPolicy;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
@Getter(AccessLevel.NONE)
@ToString
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class User extends AbstractAggregateRoot<User> {
    @Id
    private Integer id;
    private String email;
    private final String name;

    public static User with(String name, String email) {
        return new User(null, name, email);
    }

    public void changeEmail(String newEmail, UserEmailPolicy userEmailPolicy) {
        userEmailPolicy.verifyEmail(newEmail);
        var oldMail = this.email;
        this.email = newEmail;
        registerEvent(new UserEmailChangedEvent(oldMail, newEmail));
    }
}
