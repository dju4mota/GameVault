package octodevs.gamevault.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import octodevs.gamevault.models.Review;
import octodevs.gamevault.repositories.ReviewRepository;
import octodevs.gamevault.repositories.dto.review.ReviewDtoCompleteSaida;
import octodevs.gamevault.repositories.dto.review.ReviewDtoEntrada;
import octodevs.gamevault.repositories.dto.review.ReviewDtoPut;
import octodevs.gamevault.repositories.dto.review.ReviewDtoSaida;


/**
 * A classe Review Service manipula os dados de Review, utiliza GameService e UserService para algumas operações em conjunto.
 * Utiliza ReviewRepository para operar no banco. 
 * Recebe Dtos de entrada e cria Dtos de saída
 */
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
        System.out.println(reviewDTO);
        // Ligações com outras entidades             
        gameService.addReview(reviewDTO.gameId(),reviewDTO.reviewId());
        userService.addReview(reviewDTO.userId(),reviewDTO.reviewId());
        return reviewDTO;             
    }


    public ReviewDtoSaida getReviewbyId(String id){
        return reviewRepository.findById(id).map(ReviewDtoSaida::new).orElse(null);
    }

    public Stream<ReviewDtoSaida> getAllReviews(Pageable pageable){
        return reviewRepository.findAll(pageable).stream().map(ReviewDtoSaida::new);
    }

    public ReviewDtoCompleteSaida getReviewCompletebyId(String id){
        
        ReviewDtoSaida review = getReviewbyId(id);
        if(review != null){
            ReviewDtoCompleteSaida saida = new ReviewDtoCompleteSaida(review, gameService.getGameById(review.gameId()), userService.getUserById(review.userId()));        
            return saida;
        }
        return null;        
    }

    public List<ReviewDtoCompleteSaida> getAllReviewsComplete(Pageable pageable){
        List<ReviewDtoSaida> reviews = getAllReviews(pageable).toList();
        
        List<ReviewDtoCompleteSaida> reviewsSaida = new ArrayList<>();

        for (ReviewDtoSaida review : reviews) {
            try {
                reviewsSaida.add(getReviewCompletebyId(review.reviewId()));    
            } catch (Exception e) {
                System.out.println("Erro no item: " + review);
                continue;
            }
            
        }
        return reviewsSaida;
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
