package br.octodevs.GameVault.repository;


import br.octodevs.GameVault.model.game.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game,Long> {
}
