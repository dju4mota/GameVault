package br.octodevs.GameVault.service;

import br.octodevs.GameVault.model.Review;
import br.octodevs.GameVault.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    public Review saveReview(Review review){
        if(reviewRepository.existsById(review.getReviewId()))
            return null;
        return reviewRepository.save(review);
    }

    public Iterable<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(Long id){
        return reviewRepository.findById(id);
    }

    public Review updateById(Long id, Review review){
        if(reviewRepository.existsById(id)){
            return reviewRepository.save(review);
        }
        return null;
    }

    public void deleteById(Long id){
        reviewRepository.deleteById(id);
    }
}
