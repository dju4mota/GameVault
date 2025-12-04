package br.octodevs.GameVault.controller;

import br.octodevs.GameVault.model.game.Game;
import br.octodevs.GameVault.model.game.GameDTO_Entrada;
import br.octodevs.GameVault.model.game.GameDTO_Saida;
import br.octodevs.GameVault.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/review")
public class GameController {

    @Autowired
    GameService gameService;

    @PostMapping()
    public ResponseEntity<GameDTO_Saida> createGame(@RequestBody GameDTO_Entrada review){
        return ResponseEntity.ok(new GameDTO_Saida(gameService.saveGame(review)));
    }

    @GetMapping()
    public GameDTO_Saida getGameByID(@RequestParam Long id){
        try {
            return new GameDTO_Saida( gameService.getGameById(id).get());
        } catch (NoSuchElementException e) {
            System.out.println(" Não achou Id");
            return null;
        }
    }

    @GetMapping("/all")
    public Iterable<Game> getAllGames(){
        return gameService.getAllGames();
    }

    @PutMapping()
    public GameDTO_Saida updateGameByID(@RequestParam Long id, @RequestBody Game review){
        try {
            return new GameDTO_Saida( gameService.updateById(id, review));
        } catch (NoSuchElementException e) {
            System.out.println(" Não achou Id");
            return null;
        }
    }

    @DeleteMapping()
    public void deleteGameById(@RequestParam Long id){
        gameService.deleteById(id);
    }
}
