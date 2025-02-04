package octodevs.gamevault.models;

import jakarta.persistence.Embeddable;
import octodevs.gamevault.dto.game.DtoPostGame;

@Embeddable
public class Game {

    private String title;
    private String description;
    private String genre;

    public Game(DtoPostGame dtoPostGame) {
        this.title = dtoPostGame.title();
        this.description = dtoPostGame.description();
        this.genre = dtoPostGame.genre();
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

