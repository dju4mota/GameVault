package octodevs.gamevault.controllers;

import jakarta.validation.Valid;
import octodevs.gamevault.models.Review;
import octodevs.gamevault.repositories.ReviewRepository;
import octodevs.gamevault.repositories.dto.ReviewDtoGet;
import octodevs.gamevault.repositories.dto.ReviewDtoPost;
import octodevs.gamevault.repositories.dto.ReviewDtoPut;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    final ReviewRepository reviewRepository;

    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    // Create
    @PostMapping
    @Transactional
    public ResponseEntity createReview(@RequestBody @Valid ReviewDtoPost DTOreview, UriComponentsBuilder uriBuilder) {
        // TODO adicionar gameID
        Review review = new Review(DTOreview);
        System.out.println(review);
        reviewRepository.save(review);
        return ResponseEntity.created(uriBuilder.path("/reviews/{id}").buildAndExpand(review.getReviewId()).toUri())
                .body(new ReviewDtoGet(review));
    }

    // Read
    @GetMapping
    public ResponseEntity<Stream<ReviewDtoGet>> getAllReviews(Pageable pageable) {
        Stream<ReviewDtoGet> reviews = reviewRepository.findAll(pageable).stream().map(ReviewDtoGet::new);
        return ResponseEntity.ok(reviews);
    }

    // get by Id
    @GetMapping("/{id}")
    public ResponseEntity<ReviewDtoGet> getReviewbyId(@PathVariable String id) {
        Optional<Review> review = reviewRepository.findById(id);
        // TODO mensagem de não encontrado 404
        return ResponseEntity.ok(review.map(ReviewDtoGet::new).orElse(null));
    }

    // Update
    @PutMapping ("/{id}")
    @Transactional
    public ResponseEntity updateById(@PathVariable String id, @RequestBody ReviewDtoPut dtoPut) {
        Review review = reviewRepository.getReferenceById(id);
        review.atualizarDados(dtoPut);
        // TODO mensagem de não encontrado 404
        return ResponseEntity.ok(new ReviewDtoGet(reviewRepository.save(review)));
    }

    // Delete
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteReviewById(@PathVariable String id) {
        reviewRepository.deleteById(id);
        // TODO mensagem de não encontrado 404
        return  ResponseEntity.noContent().build();
    }
}
