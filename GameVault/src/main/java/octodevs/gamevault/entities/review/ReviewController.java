package octodevs.gamevault.entities.review;

import jakarta.validation.Valid;
import octodevs.gamevault.entities.review.dto.ReviewDtoGet;
import octodevs.gamevault.entities.review.dto.ReviewDtoPost;
import octodevs.gamevault.entities.review.dto.ReviewDtoPut;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    ReviewRepository reviewRepository;

    // Create
    @PostMapping
    @Transactional
    public ResponseEntity createReview(@RequestBody @Valid ReviewDtoPost DTOreview, UriComponentsBuilder uriBuilder) {
        // TODO verificar ID duplicado e resposta disso
        Review review = new Review(DTOreview);
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
    public ResponseEntity<ReviewDtoGet> getReviewbyId(@PathVariable Long id) {
        Optional<Review> review = reviewRepository.findById(id);
        // TODO mensagem de não encontrado 404
        return ResponseEntity.ok(review.map(ReviewDtoGet::new).orElse(null));
    }

    // Update
    @PutMapping ("/{id}")
    @Transactional
    public ResponseEntity updateById(@PathVariable Long id, @RequestBody ReviewDtoPut dtoPut) {
        Review review = reviewRepository.getReferenceById(id);
        review.atualizarDados(dtoPut);
        // TODO mensagem de não encontrado 404
        return ResponseEntity.ok(new ReviewDtoGet(reviewRepository.save(review)));
    }

    // Delete
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteReviewById(@PathVariable Long id) {
        reviewRepository.deleteById(id);
        // TODO mensagem de não encontrado 404
        return  ResponseEntity.noContent().build();
    }
}
