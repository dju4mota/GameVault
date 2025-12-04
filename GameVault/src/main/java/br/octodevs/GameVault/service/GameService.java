package br.octodevs.GameVault.service;

import br.octodevs.GameVault.model.game.Game;
import br.octodevs.GameVault.model.game.GameDTO_Entrada;
import br.octodevs.GameVault.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    public Game saveGame(GameDTO_Entrada game){
        return gameRepository.save(new Game(game));
    }

    public Iterable<Game> getAllGames(){
        return gameRepository.findAll();
    }

    public Optional<Game> getGameById(Long id){
        return gameRepository.findById(id);
    }

    public Game updateById(Long id, Game game){
        return gameRepository.save(game);
    }

    public void deleteById(Long id){
        gameRepository.deleteById(id);
    }
}
