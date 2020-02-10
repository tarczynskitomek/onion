package it.tarczynski.onion.user.policy;

import it.tarczynski.onion.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultUserEmailPolicy implements UserEmailPolicy {
    private final UserRepository userRepository;

    @Override
    public void verifyEmail(String email) {
        if (emailAlreadyUsed(email)) {
            throw new IllegalStateException("The email has already been used");
        }
    }

    private boolean emailAlreadyUsed(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
