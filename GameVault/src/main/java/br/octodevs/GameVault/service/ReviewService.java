package br.octodevs.GameVault.service;

import br.octodevs.GameVault.model.review.Review;
import br.octodevs.GameVault.model.review.ReviewDTO_Entrada;
import br.octodevs.GameVault.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    public Review saveReview(ReviewDTO_Entrada review){
        return reviewRepository.save(new Review(review));
    }

    public Iterable<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(Long id){
        return reviewRepository.findById(id);
    }

    public Review updateById(Long id, Review review){
        return reviewRepository.save(review);
    }

    public void deleteById(Long id){
        reviewRepository.deleteById(id);
    }
}
