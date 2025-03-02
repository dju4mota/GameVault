package octodevs.gamevault.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import octodevs.gamevault.models.Review;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<Review, String> {
}
