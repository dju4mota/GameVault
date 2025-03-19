package octodevs.gamevault.controllers;

import jakarta.validation.Valid;
import octodevs.gamevault.repositories.dto.review.ReviewDtoCompleteSaida;
import octodevs.gamevault.repositories.dto.review.ReviewDtoEntrada;
import octodevs.gamevault.repositories.dto.review.ReviewDtoPut;
import octodevs.gamevault.repositories.dto.review.ReviewDtoSaida;
import octodevs.gamevault.services.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.stream.Stream;

// Controller responsavel por rotas e respostas
// Recebe e envia DTO's

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;


    // Create
    @PostMapping
    public ResponseEntity<ReviewDtoSaida> createReview(@RequestBody @Valid ReviewDtoEntrada dtoEntrada, UriComponentsBuilder uriBuilder) {
        
        ReviewDtoSaida reviewResposta = reviewService.createReview(dtoEntrada);

        return ResponseEntity.created(uriBuilder.path("/reviews/{id}").buildAndExpand(reviewResposta.reviewId()).toUri())
                .body(reviewResposta);
    }

    
    // Read
    // Complete by Id
    @GetMapping("/complete/{id}")
    public ResponseEntity<ReviewDtoCompleteSaida> getReviewCompleteById(@PathVariable String id) {
        
        ReviewDtoCompleteSaida reviewResposta = reviewService.getReviewCompletebyId(id);
                
        if(reviewResposta != null){
            return ResponseEntity.ok(reviewResposta);
        }
        return ResponseEntity.notFound().build();
    }
    
    
    // all
    @GetMapping
    public ResponseEntity<Stream<ReviewDtoSaida>> getAllReviews(Pageable pageable) {
       
        Stream<ReviewDtoSaida> reviews = reviewService.getAllReviews(pageable);
       
        return ResponseEntity.ok(reviews);
    }

    // by Id
    @GetMapping("/{id}")
    public ResponseEntity<ReviewDtoSaida> getReviewById(@PathVariable String id) {
        
        ReviewDtoSaida reviewResposta = reviewService.getReviewbyId(id);
        if(reviewResposta != null){
            return ResponseEntity.ok(reviewResposta);
        }
        return ResponseEntity.notFound().build();
    }

    // Update
    @PutMapping ("/{id}")
    public ResponseEntity<ReviewDtoSaida> updateById(@PathVariable String id, @RequestBody ReviewDtoPut dtoPut) {
        
        ReviewDtoSaida reviewResposta  = reviewService.updatebyID(id, dtoPut);
        
        return ResponseEntity.ok(reviewResposta);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReviewById(@PathVariable String id) {
        
        reviewService.deleteById(id);
        
        return  ResponseEntity.noContent().build();
    }
}
