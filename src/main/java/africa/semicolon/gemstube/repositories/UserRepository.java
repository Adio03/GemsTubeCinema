package africa.semicolon.gemstube.repositories;

import africa.semicolon.gemstube.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u from User u where u.email=:email")
    Optional<User> findByEmail(String email);
}
