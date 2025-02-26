package octodevs.gamevault.config;

import jakarta.annotation.PostConstruct;
import octodevs.gamevault.entities.game.Game;
import octodevs.gamevault.entities.game.GameRepository;
import octodevs.gamevault.entities.review.Review;
import octodevs.gamevault.entities.review.ReviewRepository;
import octodevs.gamevault.services.JsonFileReader;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader {

    public final JsonFileReader jsonFileReader;
    private final ReviewRepository reviewRepository;
    private final GameRepository gameRepository;

    public DataLoader(ReviewRepository reviewRepository, JsonFileReader jsonFileReader, GameRepository gameRepository) {
        this.jsonFileReader = jsonFileReader;
        this.reviewRepository = reviewRepository;
        this.gameRepository = gameRepository;
    }

    @PostConstruct
    public void loadData( ) {

        List<Review> reviews = jsonFileReader.readArrayReviewFromJson("InitialDataReview.json");
        reviewRepository.saveAll(reviews);

        List<Game> games = jsonFileReader.readArrayGameFromJson("InitialDataGame.json");
        gameRepository.saveAll(games);
    }
}
