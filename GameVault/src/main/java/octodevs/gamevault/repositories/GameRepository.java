package octodevs.gamevault.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import octodevs.gamevault.models.Game;

public interface GameRepository extends JpaRepository<Game, String> {

}
