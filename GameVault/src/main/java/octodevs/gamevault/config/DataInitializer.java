package octodevs.gamevault.config;

import octodevs.gamevault.entities.review.Review;
import octodevs.gamevault.entities.review.RepositoryReview;
import octodevs.gamevault.services.JsonFileReader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class DataInitializer {

    public final JsonFileReader jsonFileReader;

    public DataInitializer(JsonFileReader jsonFileReader) {
        this.jsonFileReader = jsonFileReader;
    }

    @Bean
    public CommandLineRunner loadData(RepositoryReview reviewRepository, JsonFileReader jsonFileReader) {

        List<Review> reviews = jsonFileReader.readArrayReviewFromJson();

        return args -> reviewRepository.saveAll(reviews);
    }
}
