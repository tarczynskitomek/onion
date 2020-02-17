package it.tarczynski.onion;

import it.tarczynski.onion.user.model.User;
import it.tarczynski.onion.user.policy.UserEmailPolicy;
import it.tarczynski.onion.user.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@EnableJdbcRepositories
@SpringBootApplication(scanBasePackages = "it.tarczynski.onion")
public class OnionApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnionApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository,
                                        UserEmailPolicy emailPolicy) {
        return args -> {
            User foo = User.with("Foo", "foo@bar.baz");
            foo = userRepository.save(foo);

            foo.changeEmail("foo@bar.baz1", emailPolicy);
            System.out.println(userRepository.findByEmail("foo@bar.baz"));

            userRepository.save(foo);
            System.out.println(userRepository.findByEmail("foo@bar.baz"));
        };
    }
}
