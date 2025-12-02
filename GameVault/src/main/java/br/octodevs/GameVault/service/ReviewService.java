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
        return reviewRepository.save(review);
    }

    public Iterable<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(Long id){
        return reviewRepository.findById(id);
    }

}
