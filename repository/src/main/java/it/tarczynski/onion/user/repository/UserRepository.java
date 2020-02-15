package it.tarczynski.onion.user.repository;

import it.tarczynski.onion.user.model.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("select * from users where email = :email")
    Optional<User> findByEmail(@Param("email") String email);

}
