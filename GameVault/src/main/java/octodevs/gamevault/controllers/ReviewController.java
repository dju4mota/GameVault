package octodevs.gamevault.controllers;

import jakarta.validation.Valid;
import octodevs.gamevault.models.Review;
import octodevs.gamevault.repositories.dto.ReviewDtoGet;
import octodevs.gamevault.repositories.dto.ReviewDtoPost;
import octodevs.gamevault.repositories.dto.ReviewDtoPut;
import octodevs.gamevault.services.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;


    // Create
    @PostMapping
    public ResponseEntity createReview(@RequestBody @Valid ReviewDtoPost DTOreview, UriComponentsBuilder uriBuilder) {
        
        ReviewDtoGet reviewResposta = new ReviewDtoGet(reviewService.createReview(DTOreview));

        return ResponseEntity.created(uriBuilder.path("/reviews/{id}").buildAndExpand(reviewResposta.reviewId()).toUri())
                .body(reviewResposta);
    }

    // Read
    @GetMapping
    public ResponseEntity<Stream<ReviewDtoGet>> getAllReviews(Pageable pageable) {
       
        Stream<ReviewDtoGet> reviews = reviewService.getAllReviews(pageable);
       
        return ResponseEntity.ok(reviews);
    }

    // get by Id
    @GetMapping("/{id}")
    public ResponseEntity<ReviewDtoGet> getReviewbyId(@PathVariable String id) {
        
        Optional<Review> review = reviewService.getReviewbyId(id);
        
        return ResponseEntity.ok(review.map(ReviewDtoGet::new).orElse(null));
    }

    // Update
    @PutMapping ("/{id}")
    public ResponseEntity updateById(@PathVariable String id, @RequestBody ReviewDtoPut dtoPut) {
        
        ReviewDtoGet reviewResposta  = new ReviewDtoGet( reviewService.updatebyID(id, dtoPut));
        
        return ResponseEntity.ok(reviewResposta);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity deleteReviewById(@PathVariable String id) {
        
        reviewService.deleteById(id);
        
        return  ResponseEntity.noContent().build();
    }
}
