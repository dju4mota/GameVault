package octodevs.gamevault.controllers;

import jakarta.validation.Valid;
import octodevs.gamevault.dto.DtoGetReview;
import octodevs.gamevault.dto.DtoPostReview;
import octodevs.gamevault.dto.DtoPutReview;
import octodevs.gamevault.models.Review;
import octodevs.gamevault.repository.RepositoryReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    RepositoryReview reviewRepository;

    // Create
    @PostMapping
    @Transactional
    ResponseEntity createReview(@RequestBody @Valid DtoPostReview review) {
        reviewRepository.save(new Review(review));
        return ResponseEntity.ok().build();
    }

    // Read
    @GetMapping
    ResponseEntity<Stream<DtoGetReview>> getAllReviews(Pageable pageable) {
        Stream<DtoGetReview> reviews = reviewRepository.findAll(pageable).stream().map(DtoGetReview::new);
        return ResponseEntity.ok(reviews);
    }

    // get by Id
    @GetMapping("/{id}")
    ResponseEntity<DtoGetReview> getReviewbyId(@PathVariable Long id) {
        Optional<Review> review = reviewRepository.findById(id);
        return ResponseEntity.ok( review.map(DtoGetReview::new).orElse(null));
    }

    // Update
    @PutMapping ("/{id}")
    @Transactional
    ResponseEntity updateById(@PathVariable Long id, @RequestBody DtoPutReview dtoPut) {
        Review review = reviewRepository.getReferenceById(id);
        review.atualizarDados(dtoPut);
        return ResponseEntity.ok(new DtoGetReview(reviewRepository.save(review)));
    }

    // Delete
    @DeleteMapping("/{id}")
    @Transactional
    ResponseEntity deleteReviewById(@PathVariable Long id) {
        reviewRepository.deleteById(id);
        return  ResponseEntity.noContent().build();
    }

}
