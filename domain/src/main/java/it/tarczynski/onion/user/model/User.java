package it.tarczynski.onion.user.model;

import it.tarczynski.onion.user.policy.UserEmailPolicy;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
@Builder(access = AccessLevel.PUBLIC)
@Getter(AccessLevel.NONE)
@ToString
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class User extends AbstractAggregateRoot<User> {
    @Id
    @With
    private final Integer id;
    private final String name;
    private String email;

    public void changeEmail(String newEmail, UserEmailPolicy userEmailPolicy) {
        userEmailPolicy.verifyEmail(newEmail);
        var oldMail = this.email;
        this.email = newEmail;
        registerEvent(new UserEmailChangedEvent(oldMail, newEmail));
    }
}
