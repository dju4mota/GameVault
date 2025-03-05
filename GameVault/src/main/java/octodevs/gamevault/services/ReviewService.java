package octodevs.gamevault.services;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import octodevs.gamevault.models.Review;
import octodevs.gamevault.repositories.ReviewRepository;
import octodevs.gamevault.repositories.dto.ReviewDtoGet;
import octodevs.gamevault.repositories.dto.ReviewDtoPost;
import octodevs.gamevault.repositories.dto.ReviewDtoPut;


@Service
public class ReviewService {

    @Autowired
    public ReviewRepository reviewRepository;

    @Transactional
    public Review createReview(ReviewDtoPost DTOreview) {
        
        // TO DO adicionar gameID
        
        return reviewRepository.save(new Review(DTOreview));
    }

// To-Do  mensagem de não encontrado 404

    public Optional<Review> getReviewbyId(String id){
           return reviewRepository.findById(id);
    }

    public Stream<ReviewDtoGet> getAllReviews(Pageable pageable){
        return reviewRepository.findAll(pageable).stream().map(ReviewDtoGet::new);
    }

    @Transactional
    public Review updatebyID(String id, ReviewDtoPut reviewDtoPut){ 
        Review review = reviewRepository.getReferenceById(id);
        review.atualizarDados(reviewDtoPut);
        return reviewRepository.save(review);
    }


    @Transactional
    public void deleteById(String id){
        reviewRepository.deleteById(id);
    }

}
