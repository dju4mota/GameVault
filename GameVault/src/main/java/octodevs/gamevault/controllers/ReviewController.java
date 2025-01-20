package octodevs.gamevault.controllers;

import octodevs.gamevault.dto.DtoGetReview;
import octodevs.gamevault.dto.DtoPostReview;
import octodevs.gamevault.models.Review;
import octodevs.gamevault.repository.RepositoryReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    RepositoryReview reviewRepository;


    // Create
    @PostMapping
    void createReview(@RequestBody DtoPostReview review) {
        reviewRepository.save(new Review(review));
        System.out.println("Creating review");
        System.out.println(review);
        Review newReview = new Review(review);
    }

    // Read
    @GetMapping
    Stream<DtoGetReview> getAllReviews() {
        Stream<DtoGetReview> reviews = reviewRepository.findAll().stream().map(DtoGetReview::new);
        System.out.println(reviews);
        System.out.println("Live Reload");
        return reviews;
    }


    // Update

    // Delete


}
