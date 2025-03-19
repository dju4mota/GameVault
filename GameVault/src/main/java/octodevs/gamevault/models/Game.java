package octodevs.gamevault.models;

import java.util.ArrayList;

import jakarta.persistence.*;
import octodevs.gamevault.repositories.dto.game.GameDtoEntrada;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String gameId;
    private String title;
    private String description;
    private String genre;
    private String photo;
    private ArrayList<String> reviewsIds;

    public Game(GameDtoEntrada gameDtoPost) {
        this.title = gameDtoPost.title();
        this.description = gameDtoPost.description();
        this.genre = gameDtoPost.genre();
        reviewsIds = new ArrayList<String>();
        this.photo = gameDtoPost.photo();
    }

    public Game() {
    }

    public Game(String gameId, String title, String description, String genre, String photo) {
        this.gameId = gameId;
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.photo = photo;
        reviewsIds = new ArrayList<String>();
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

    public ArrayList<String> getReviewsIds() {
        return reviewsIds;
    }
    
    public void addReview(String reviewId){
        if(reviewsIds == null){
            reviewsIds = new ArrayList<String>();
        }
        reviewsIds.add(reviewId);
    }

    public String getPhoto() {
        return photo;
    }
    
}

