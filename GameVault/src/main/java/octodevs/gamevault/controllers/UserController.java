package octodevs.gamevault.controllers;

import jakarta.validation.Valid;
import octodevs.gamevault.repositories.dto.UserDtoEntrada;
import octodevs.gamevault.repositories.dto.UserDtoOut;
import octodevs.gamevault.services.UserService;

import java.util.stream.Stream;

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

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;    

    @PostMapping
    public ResponseEntity createUser(@RequestBody @Valid UserDtoEntrada dtoEntrada, UriComponentsBuilder uriBuilder) {
        
        UserDtoOut userResposta = userService.createUser(dtoEntrada);

        return ResponseEntity.created(uriBuilder.path("/games/{id}").buildAndExpand(userResposta.userId()).toUri())
                .body(userResposta);
    }

    // Read
    @GetMapping
    public ResponseEntity<Stream<UserDtoOut>> getAllUsers(Pageable pageable) {
        Stream<UserDtoOut> users = userService.getAllUsers(pageable);
        return ResponseEntity.ok(users);
    }

    // get by Id
    @GetMapping("/{id}")
    public ResponseEntity<UserDtoOut> getUserById(@PathVariable String id) {
        UserDtoOut user = userService.getUserById(id);
        // TO DO mensagem de não encontrado 404
        return ResponseEntity.ok(user);
    }

}
