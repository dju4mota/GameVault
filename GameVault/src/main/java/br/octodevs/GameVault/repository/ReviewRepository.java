package br.octodevs.GameVault.repository;

import br.octodevs.GameVault.model.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review,Long> {
}
