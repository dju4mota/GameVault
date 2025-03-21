package octodevs.gamevault.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import octodevs.gamevault.models.UserAccount;


public interface UserRepository extends JpaRepository<UserAccount, String> {    
    UserAccount findByUserName(String userName);
}
