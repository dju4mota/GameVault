package br.octodevs.GameVault.repository;

import br.octodevs.GameVault.model.review.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review,Long> {
}
