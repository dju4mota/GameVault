package br.octodevs.GameVault.controller;

import br.octodevs.GameVault.model.review.Review;
import br.octodevs.GameVault.model.review.ReviewDTO_Entrada;
import br.octodevs.GameVault.model.review.ReviewDTO_Saida;
import br.octodevs.GameVault.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping()
    public ResponseEntity<ReviewDTO_Saida> createReview(@RequestBody ReviewDTO_Entrada review){
        return ResponseEntity.ok(new ReviewDTO_Saida(reviewService.saveReview(review)));
    }

    @GetMapping()
    public ReviewDTO_Saida getReviewByID(@RequestParam Long id){
        try {
            return new ReviewDTO_Saida( reviewService.getReviewById(id).get());
        } catch (NoSuchElementException e) {
            System.out.println(" Não achou Id");
            return null;
        }
    }

    @GetMapping("/all")
    public Iterable<Review> getAllReviews(){
        return reviewService.getAllReviews();
    }

    @PutMapping()
    public ReviewDTO_Saida updateReviewByID(@RequestParam Long id, @RequestBody Review review){
        try {
            return new ReviewDTO_Saida( reviewService.updateById(id, review));
        } catch (NoSuchElementException e) {
            System.out.println(" Não achou Id");
            return null;
        }
    }

    @DeleteMapping()
    public void deleteReviewById(@RequestParam Long id){
        reviewService.deleteById(id);
    }
}
