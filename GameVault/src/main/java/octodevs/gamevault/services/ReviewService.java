package octodevs.gamevault.services;

import java.util.stream.Stream;

import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import octodevs.gamevault.models.Review;
import octodevs.gamevault.repositories.ReviewRepository;
import octodevs.gamevault.repositories.dto.review.ReviewDtoCompleteSaida;
import octodevs.gamevault.repositories.dto.review.ReviewDtoEntrada;
import octodevs.gamevault.repositories.dto.review.ReviewDtoPut;
import octodevs.gamevault.repositories.dto.review.ReviewDtoSaida;


// Service 
// Entrada e Saída com DTOs
// Manipula os Reviews

@Service
public class ReviewService {

    @Autowired
    public ReviewRepository reviewRepository;

    @Autowired
    public GameService gameService;

    @Autowired
    public UserService userService;

    @Transactional
    public ReviewDtoSaida createReview(ReviewDtoEntrada DTOreview) {

        ReviewDtoSaida reviewDTO = new ReviewDtoSaida(reviewRepository.save(new Review(DTOreview)));

        // Ligações com outras tabelas
        gameService.addReview(reviewDTO.gameId(), reviewDTO.reviewId());
        userService.addReview(reviewDTO.userId(), reviewDTO.reviewId());

        return reviewDTO;
    }

// To-Do  mensagem de não encontrado 404

    public ReviewDtoSaida getReviewbyId(String id){
        return reviewRepository.findById(id).map(ReviewDtoSaida::new).orElse(null);
    }

    public Stream<ReviewDtoSaida> getAllReviews(Pageable pageable){
        return reviewRepository.findAll(pageable).stream().map(ReviewDtoSaida::new);
    }

    public ReviewDtoCompleteSaida getReviewCompletebyId(String id){
        // To Do -> Verificação e try-catch 
        ReviewDtoSaida review = getReviewbyId(id);
        ReviewDtoCompleteSaida saida = new ReviewDtoCompleteSaida(review, gameService.getGameById(review.gameId()), userService.getUserById(review.userId()));        
        return saida;        
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
