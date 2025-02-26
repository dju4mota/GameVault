package octodevs.gamevault.entities.game;

import jakarta.persistence.*;
import octodevs.gamevault.entities.game.dto.GameDtoPost;

import java.util.UUID;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID gameId;
    private String title;
    private String description;
    private String genre;

    public Game(GameDtoPost gameDtoPost) {
        this.title = gameDtoPost.title();
        this.description = gameDtoPost.description();
        this.genre = gameDtoPost.genre();
    }

    public Game() {
    }

    public Game(UUID gameId, String title, String description, String genre) {
        this.gameId = gameId;
        this.title = title;
        this.description = description;
        this.genre = genre;
    }

    public UUID getGameId() {
        return gameId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getGenre() {
        return genre;
    }
}

