package octodevs.gamevault.controllers;

import octodevs.gamevault.repositories.dto.GameDtoEntrada;
import octodevs.gamevault.repositories.dto.GameDtoSaida;
import octodevs.gamevault.services.GameService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;

import java.util.stream.Stream;

@RestController
@RequestMapping("/games")
public class GameController {
    
    @Autowired
    private GameService gameService;    

    @PostMapping
    public ResponseEntity createGame(@RequestBody @Valid GameDtoEntrada dtoEntrada, UriComponentsBuilder uriBuilder) {
        
        GameDtoSaida gameResposta = gameService.createGame(dtoEntrada);

        return ResponseEntity.created(uriBuilder.path("/games/{id}").buildAndExpand(gameResposta.gameId()).toUri())
                .body(gameResposta);
    }

    // Read
    @GetMapping
    public ResponseEntity<Stream<GameDtoSaida>> getAllGames(Pageable pageable) {
        Stream<GameDtoSaida> games = gameService.getAllGames(pageable);
        return ResponseEntity.ok(games);
    }

    // get by Id
    @GetMapping("/{id}")
    public ResponseEntity<GameDtoSaida> getGameById(@PathVariable String id) {
        GameDtoSaida game = gameService.getGameById(id);
        // TO DO mensagem de não encontrado 404
        return ResponseEntity.ok(game);
    }

}
