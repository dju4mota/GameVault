package octodevs.gamevault.controllers;


import org.springframework.security.crypto.password.PasswordEncoder;
import jakarta.validation.Valid;
import octodevs.gamevault.models.User;
import octodevs.gamevault.repositories.UserRepository;
import octodevs.gamevault.repositories.dto.UserDtoEntrada;
import octodevs.gamevault.repositories.dto.GameDtoSaida;
import octodevs.gamevault.services.UserService;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;    

    @PostMapping
    public ResponseEntity createGame(@RequestBody @Valid UserDtoEntrada dtoEntrada, UriComponentsBuilder uriBuilder) {
        
        GameDtoSaida gameResposta = userService.createGame(dtoEntrada);

        return ResponseEntity.created(uriBuilder.path("/games/{id}").buildAndExpand(gameResposta.gameId()).toUri())
                .body(gameResposta);
    }

    // Read
    @GetMapping
    public ResponseEntity<Stream<GameDtoSaida>> getAllGames(Pageable pageable) {
        Stream<GameDtoSaida> games = userService.getAllGames(pageable);
        return ResponseEntity.ok(games);
    }

    // get by Id
    @GetMapping("/{id}")
    public ResponseEntity<GameDtoSaida> getGameById(@PathVariable String id) {
        GameDtoSaida game = userService.getGameById(id);
        // TO DO mensagem de não encontrado 404
        return ResponseEntity.ok(game);
    }

}
