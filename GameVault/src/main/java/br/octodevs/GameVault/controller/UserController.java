package br.octodevs.GameVault.controller;

import br.octodevs.GameVault.model.user.User;
import br.octodevs.GameVault.model.user.UserDTO_Entrada;
import br.octodevs.GameVault.model.user.UserDTO_Saida;
import br.octodevs.GameVault.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping()
    public ResponseEntity<UserDTO_Saida> createUser(@RequestBody UserDTO_Entrada user){
        return ResponseEntity.ok(new UserDTO_Saida(userService.saveUser(user)));
    }

    @GetMapping()
    public UserDTO_Saida getUserByID(@RequestParam Long id){
        try {
            return new UserDTO_Saida( userService.getUserById(id).get());
        } catch (NoSuchElementException e) {
            System.out.println(" Não achou Id");
            return null;
        }
    }

    @GetMapping("/all")
    public Iterable<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping()
    public UserDTO_Saida updateUserByID(@RequestParam Long id, @RequestBody User user){
        try {
            return new UserDTO_Saida( userService.updateById(id, user));
        } catch (NoSuchElementException e) {
            System.out.println(" Não achou Id");
            return null;
        }
    }

    @DeleteMapping()
    public void deleteUserById(@RequestParam Long id){
        userService.deleteById(id);
    }
}
