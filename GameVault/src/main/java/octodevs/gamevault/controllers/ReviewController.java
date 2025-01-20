package octodevs.gamevault.controllers;

import octodevs.gamevault.dto.DtoGetReview;
import octodevs.gamevault.dto.DtoPostReview;
import octodevs.gamevault.models.Review;
import octodevs.gamevault.repository.RepositoryReview;
import org.springframework.beans.factory.annotation.Autowired;
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
    void createReview(@RequestBody DtoPostReview review) {
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

    // Delete


}
