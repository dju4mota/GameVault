package octodevs.gamevault.controllers;

import jakarta.validation.Valid;
import octodevs.gamevault.repositories.dto.ReviewDtoSaida;
import octodevs.gamevault.repositories.dto.ReviewDtoEntrada;
import octodevs.gamevault.repositories.dto.ReviewDtoPut;
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
    public ResponseEntity createReview(@RequestBody @Valid ReviewDtoEntrada dtoEntrada, UriComponentsBuilder uriBuilder) {
        
        ReviewDtoSaida reviewResposta = reviewService.createReview(dtoEntrada);

        return ResponseEntity.created(uriBuilder.path("/reviews/{id}").buildAndExpand(reviewResposta.reviewId()).toUri())
                .body(reviewResposta);
    }

    // Read
    // all
    @GetMapping
    public ResponseEntity<Stream<ReviewDtoSaida>> getAllReviews(Pageable pageable) {
       
        Stream<ReviewDtoSaida> reviews = reviewService.getAllReviews(pageable);
       
        return ResponseEntity.ok(reviews);
    }

    // by Id
    @GetMapping("/{id}")
    public ResponseEntity<ReviewDtoSaida> getReviewbyId(@PathVariable String id) {
        
        ReviewDtoSaida reviewResposta = reviewService.getReviewbyId(id);
        
        return ResponseEntity.ok(reviewResposta);
    }

    // Update
    @PutMapping ("/{id}")
    public ResponseEntity updateById(@PathVariable String id, @RequestBody ReviewDtoPut dtoPut) {
        
        ReviewDtoSaida reviewResposta  = reviewService.updatebyID(id, dtoPut);
        
        return ResponseEntity.ok(reviewResposta);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity deleteReviewById(@PathVariable String id) {
        
        reviewService.deleteById(id);
        
        return  ResponseEntity.noContent().build();
    }
}
