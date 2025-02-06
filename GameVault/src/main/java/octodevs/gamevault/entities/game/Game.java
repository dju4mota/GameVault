package octodevs.gamevault.entities.game;

import jakarta.persistence.Embeddable;
import octodevs.gamevault.entities.game.dto.GameDtoPost;

@Embeddable
public class Game {

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

    public Game(String title, String description, String genre) {
        this.title = title;
        this.description = description;
        this.genre = genre;
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

