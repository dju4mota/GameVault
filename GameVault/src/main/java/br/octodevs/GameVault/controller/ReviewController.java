package br.octodevs.GameVault.controller;

import br.octodevs.GameVault.model.Review;
import br.octodevs.GameVault.model.dto.ReviewDTO_Saida;
import br.octodevs.GameVault.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping()
    public ResponseEntity<ReviewDTO_Saida> createReview(@RequestBody Review review){
        Review r = reviewService.saveReview(review);
        ReviewDTO_Saida rDTO =  new ReviewDTO_Saida(r.getReviewId());
        System.out.println(r);
        return ResponseEntity.ok(rDTO);
    }

    @GetMapping()
    public ReviewDTO_Saida getReviewByID(@RequestParam Long id){
        try {
            return new ReviewDTO_Saida( reviewService.getReviewById(id).get().getReviewId());
        } catch (NoSuchElementException e) {
            System.out.println(" Não achou");
            return null;
        }
    }

    @GetMapping("/all")
    public Iterable<Review> getAllReviews(){
        return reviewService.getAllReviews();
    }
}
