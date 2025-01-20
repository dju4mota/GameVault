package octodevs.gamevault.repository;

import octodevs.gamevault.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryReview extends JpaRepository<Review, Long> {
}
