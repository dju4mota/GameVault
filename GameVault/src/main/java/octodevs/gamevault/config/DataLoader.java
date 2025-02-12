package octodevs.gamevault.config;

import jakarta.annotation.PostConstruct;
import octodevs.gamevault.entities.review.Review;
import octodevs.gamevault.entities.review.ReviewRepository;
import octodevs.gamevault.services.JsonFileReader;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader {

    public final JsonFileReader jsonFileReader;
    private final ReviewRepository reviewRepository;

    public DataLoader(ReviewRepository reviewRepository, JsonFileReader jsonFileReader) {
        this.jsonFileReader = jsonFileReader;
        this.reviewRepository = reviewRepository;
    }

    @PostConstruct
    public void loadData( ) {

        List<Review> reviews = jsonFileReader.readArrayReviewFromJson();

        reviewRepository.saveAll(reviews);
    }
}
