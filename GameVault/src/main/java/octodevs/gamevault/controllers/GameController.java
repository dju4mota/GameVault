package octodevs.gamevault.controllers;


import octodevs.gamevault.repositories.GameRepository;
import octodevs.gamevault.repositories.dto.GameDtoGet;
import octodevs.gamevault.models.Game;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/games")
public class GameController {

    final GameRepository gameRepository;

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    // Read
    @GetMapping
    public ResponseEntity<Stream<GameDtoGet>> getAllReviews(Pageable pageable) {
        Stream<GameDtoGet> games = gameRepository.findAll(pageable).stream().map(GameDtoGet::new);
        return ResponseEntity.ok(games);
    }

    // get by Id
    @GetMapping("/{id}")
    public ResponseEntity<GameDtoGet> getReviewbyId(@PathVariable String id) {
        Optional<Game> game = gameRepository.findById(id);
        // TODO mensagem de não encontrado 404
        return ResponseEntity.ok(game.map(GameDtoGet::new).orElse(null));
    }

}
