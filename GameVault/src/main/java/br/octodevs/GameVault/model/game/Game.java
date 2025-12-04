package br.octodevs.GameVault.model.game;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gameId;
    private String title;
    private String description;
    private String genre;

    public Game() {
    }

    public Game(GameDTO_Entrada game) {
        this.title = game.title();
        this.description = game.description();
        this.genre = game.genre();
    }
}
