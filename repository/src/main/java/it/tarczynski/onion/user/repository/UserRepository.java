package it.tarczynski.onion.user.repository;

import it.tarczynski.onion.user.model.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("select u from user where email = ?")
    Optional<User> findByEmail(String email);

}
