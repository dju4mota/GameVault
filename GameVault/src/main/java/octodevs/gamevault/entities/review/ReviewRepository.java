package octodevs.gamevault.entities.review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<Review, String> {
}
