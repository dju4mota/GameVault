package octodevs.gamevault.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import octodevs.gamevault.models.UserAccount;


public interface UserRepository extends JpaRepository<UserAccount, String> {    
    UserDetails findByUserName(String userName);
}
