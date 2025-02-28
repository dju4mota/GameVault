package octodevs.gamevault.entities.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByLogin(String login);
    boolean existsByLogin(String login);
}
