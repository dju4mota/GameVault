package octodevs.gamevault.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import octodevs.gamevault.models.User;


public interface UserRepository extends JpaRepository<User, String> {    
}
