package octodevs.gamevault.models;

import java.util.ArrayList;

import jakarta.persistence.*;
import octodevs.gamevault.repositories.dto.GameDtoEntrada;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String gameId;
    private String title;
    private String description;
    private String genre;
    private ArrayList<String> reviewList;

    public Game(GameDtoEntrada gameDtoPost) {
        this.title = gameDtoPost.title();
        this.description = gameDtoPost.description();
        this.genre = gameDtoPost.genre();
        reviewList = new ArrayList<String>();
    }

    public Game() {
    }

    public Game(String gameId, String title, String description, String genre) {
        this.gameId = gameId;
        this.title = title;
        this.description = description;
        this.genre = genre;
        reviewList = new ArrayList<String>();
    }

    public String getGameId() {
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

    public ArrayList<String> getReviewList() {
        return reviewList;
    }
    
}

