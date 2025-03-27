package octodevs.gamevault.controllers;

import octodevs.gamevault.repositories.dto.user.UserDtoOut;
import octodevs.gamevault.repositories.dto.user.UserDtoSaidaReviews;
import octodevs.gamevault.services.CombinedSearchsService;
import octodevs.gamevault.services.UserService;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
* A Classe controller para as operaçãos de User.
* Utiliza UserService e CombinedSearch.
* Recebe as requisições HTTP com Dtos de Entrada e devolve respostas HTTP com Dtos de saída.
*/
@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;    
    @Autowired
    private CombinedSearchsService combinedSearchsService;

    // Responsabilidade de criação agr é do login 
    // @PostMapping
    // public ResponseEntity<UserDtoOut> createUser(@RequestBody @Valid UserDtoEntrada dtoEntrada, UriComponentsBuilder uriBuilder) {
        
    //     UserDtoOut userResposta = userService.createUser(dtoEntrada);

    //     return ResponseEntity.created(uriBuilder.path("/games/{id}").buildAndExpand(userResposta.userId()).toUri())
    //             .body(userResposta);
    // }

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
        if(user != null){
            return ResponseEntity.ok(user);
        }        
        return ResponseEntity.notFound().build();        
    }

    // get by Id com reviews 
    @GetMapping("/reviews/{id}")
    public ResponseEntity<UserDtoSaidaReviews> getUserAndReviewById(@PathVariable String id) {
        UserDtoSaidaReviews user = combinedSearchsService.getUserAndReviewsById(id);
        if(user != null)    {
            return ResponseEntity.ok(user);
        }        
        return ResponseEntity.notFound().build();
    }

    //Get user and games 
    //get friends by userid
    //get friends games  by userId

}
