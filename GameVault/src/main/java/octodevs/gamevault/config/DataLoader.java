package octodevs.gamevault.config;

import jakarta.annotation.PostConstruct;
import octodevs.gamevault.models.Game;
import octodevs.gamevault.models.Review;
import octodevs.gamevault.repositories.GameRepository;
import octodevs.gamevault.repositories.ReviewRepository;
import octodevs.gamevault.services.JsonFileReader;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Profile;
import java.util.List;

@Component
@Profile("dev")
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
