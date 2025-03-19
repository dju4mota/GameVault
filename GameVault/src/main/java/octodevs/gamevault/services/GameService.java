package octodevs.gamevault.services;

import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import octodevs.gamevault.models.Game;
import octodevs.gamevault.repositories.GameRepository;
import octodevs.gamevault.repositories.dto.game.GameDtoEntrada;
import octodevs.gamevault.repositories.dto.game.GameDtoSaida;


@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;


    @Transactional
    public GameDtoSaida createGame(GameDtoEntrada dtoEntrada) {
        // TO DO  gameID e userId        
        GameDtoSaida dtoSaida = new GameDtoSaida(gameRepository.save(new Game(dtoEntrada)));
        return dtoSaida;
    }

    @Transactional
    public void addReview(String gameId, String reviewId){        
        Game game = gameRepository.getReferenceById(gameId);
        game.addReview(reviewId);
        gameRepository.save(game);
    }

    // Read    
    public Stream<GameDtoSaida> getAllGames(Pageable pageable) {    
        return gameRepository.findAll(pageable).stream().map(GameDtoSaida::new);
    }
    
    // get by Id    
    public GameDtoSaida getGameById(String id) {        
        // TO DO mensagem de não encontrado 404
        return gameRepository.findById(id).map(GameDtoSaida::new).orElse(null);
    }

}
