package octodevs.gamevault.controllers;

import jakarta.validation.Valid;
import octodevs.gamevault.dto.DtoGetReview;
import octodevs.gamevault.dto.DtoPostReview;
import octodevs.gamevault.dto.DtoPutReview;
import octodevs.gamevault.models.Review;
import octodevs.gamevault.repository.RepositoryReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    //todo validation
    @PostMapping
    @Transactional
    void createReview(@RequestBody @Valid DtoPostReview review) {
        reviewRepository.save(new Review(review));
        System.out.println("Creating review");
    }

    // Read
    // TODO pages
    @GetMapping
    Stream<DtoGetReview> getAllReviews() {
        Stream<DtoGetReview> reviews = reviewRepository.findAll().stream().map(DtoGetReview::new);
        System.out.println("Getting all reviews");
        return reviews;
    }

    // get by Id
    @GetMapping("/{id}")
    DtoGetReview getReviewbyId(@PathVariable Long id) {
        Optional<Review> review = reviewRepository.findById(id);
        System.out.println("Getting id " + id);
        return review.map(DtoGetReview::new).orElse(null);
    }
    // TODO get by games

    // Update
    @PutMapping
    @Transactional
    void updateById(@PathVariable Long id, @RequestBody DtoPutReview dtoPut) {
        Review review = reviewRepository.getReferenceById(id);
        review.atualizarDados(dtoPut);
    }

    // Delete
    @DeleteMapping
    void deleteReviewById(@PathVariable Long id) {
        reviewRepository.deleteById(id);
    }

}
