package octodevs.gamevault.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import octodevs.gamevault.models.User;


public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByLogin(String login);
    boolean existsByLogin(String login);
}
