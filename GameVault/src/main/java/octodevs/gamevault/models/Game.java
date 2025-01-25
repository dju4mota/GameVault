package octodevs.gamevault.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import octodevs.gamevault.dto.game.DtoPostGame;

@Embeddable
@Getter
@Setter
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
}

