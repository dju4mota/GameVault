package octodevs.gamevault.services;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import octodevs.gamevault.models.Review;
import octodevs.gamevault.repositories.ReviewRepository;
import octodevs.gamevault.repositories.dto.ReviewDtoSaida;
import octodevs.gamevault.repositories.dto.ReviewDtoEntrada;
import octodevs.gamevault.repositories.dto.ReviewDtoPut;


// Service 
// Entrada e Saída com DTOs
// Manipula os Reviews

@Service
public class ReviewService {

    @Autowired
    public ReviewRepository reviewRepository;

    @Transactional
    public ReviewDtoSaida createReview(ReviewDtoEntrada DTOreview) {
        
        // TO DO adicionar gameID
        ReviewDtoSaida reviewDTO = new ReviewDtoSaida(reviewRepository.save(new Review(DTOreview)));

        return reviewDTO;
    }

// To-Do  mensagem de não encontrado 404

    public ReviewDtoSaida getReviewbyId(String id){
        return reviewRepository.findById(id).map(ReviewDtoSaida::new).orElse(null);
    }

    public Stream<ReviewDtoSaida> getAllReviews(Pageable pageable){
        return reviewRepository.findAll(pageable).stream().map(ReviewDtoSaida::new);
    }

    @Transactional
    public ReviewDtoSaida updatebyID(String id, ReviewDtoPut reviewDtoPut){ 
        Review review = reviewRepository.getReferenceById(id);
        review.atualizarDados(reviewDtoPut);
        return new ReviewDtoSaida(reviewRepository.save(review));
    }


    @Transactional
    public void deleteById(String id){
        reviewRepository.deleteById(id);
    }

}
