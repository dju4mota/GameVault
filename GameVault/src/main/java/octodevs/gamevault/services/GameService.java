package octodevs.gamevault.services;

import java.util.stream.Stream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import octodevs.gamevault.models.Game;
import octodevs.gamevault.repositories.GameRepository;
import octodevs.gamevault.repositories.dto.game.GameDtoEntrada;
import octodevs.gamevault.repositories.dto.game.GameDtoSaida;


/**
 * A classe Game Service manipula os dados de Game.
 * Utiliza GameRepository para operar no banco. 
 * Recebe Dtos de entrada e cria Dtos de saída
 */
@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;


    @Transactional
    public GameDtoSaida createGame(GameDtoEntrada dtoEntrada) {        
        GameDtoSaida dtoSaida = new GameDtoSaida(gameRepository.save(new Game(dtoEntrada)));
        return dtoSaida;
    }

    @Transactional
    public void addReview(String gameId, String reviewId){        
    
        try {
            Game game = gameRepository.getReferenceById(gameId);    
            if(game != null){
                
                game.addReview(reviewId);
                gameRepository.save(game);
            }        
        } catch (Exception e) {
            System.out.println("Game Not Found");
        }                        
    }

    // Read    
    public Page<GameDtoSaida> getAllGames(Pageable pageable) {    
        return gameRepository.findAll(pageable).map(GameDtoSaida::new);
    }
    
    // get by Id    
    public GameDtoSaida getGameById(String id) {                
        return gameRepository.findById(id).map(GameDtoSaida::new).orElse(null);
    }

    
    public Stream<GameDtoSaida> getGameByName(String title) {        
        return gameRepository.findByTitleContains(title).stream().map(GameDtoSaida::new);
    }


}
