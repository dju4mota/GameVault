package octodevs.gamevault.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import octodevs.gamevault.models.Review;
import octodevs.gamevault.repositories.dto.review.ReviewDtoEntrada;
import octodevs.gamevault.repositories.dto.review.ReviewDtoPut;
import octodevs.gamevault.repositories.dto.review.ReviewDtoSaida;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class ReviewServiceTest {
    
    @Autowired
    ReviewService reviewService;
    @Autowired
    EntityManager entityManager;

    // @Test
    // void testCreateReview() {
    //     ReviewDtoSaida reviewCriado = this.reviewService.createReview(
    //         new ReviewDtoEntrada(7, "foda", "03/05/01", "3ds", 25f, "213612763971"));
        
    //     ReviewDtoSaida reviewSaida = this.reviewService.getReviewbyId(reviewCriado.reviewId());    

    //     assertNotNull(reviewSaida);
    //     assertThat(reviewCriado).isEqualTo(reviewSaida);
    // }

    // @Test
    // void testDeleteById() {

    //     // adicionando o resultado esperado no Banco Mockado
    //     ReviewDtoSaida reviewCriado = this.reviewService.createReview(
    //         new ReviewDtoEntrada(7, "foda", "03/05/01", "3ds", 25f, "213612763971"));

    //     ReviewDtoSaida reviewSaida = this.reviewService.getReviewbyId(reviewCriado.reviewId());    
        
    //     assertNotNull(reviewSaida);
    //     assertThat(reviewCriado).isEqualTo(reviewSaida);
        
    //     this.reviewService.deleteById(reviewCriado.reviewId());

    //     reviewSaida = this.reviewService.getReviewbyId(reviewCriado.reviewId());    
        
    //     assertNull(reviewSaida);

    // }
    

    // @Test
    // void testGetAllReviewsSucess() {
        
    //     // adicionando o resultado esperado no Banco Mockado
    //     ReviewDtoSaida reviewEsperado = this.createReview(
    //         new ReviewDtoEntrada(7, "foda", "03/05/01", "3ds", 25f, "213612763971"));

    //     Pageable pageable= PageRequest.of(0, 5);

    //     List<ReviewDtoSaida> reviewEncontrado =  this.reviewService.getAllReviews(pageable).toList();
            
    //     assertThat(reviewEncontrado.get(0)).isEqualTo(reviewEsperado);
    // }
    
    // @Test
    // void testGetAllReviewsEmpty() {

    //     Pageable pageable= PageRequest.of(0, 5);

    //     List<ReviewDtoSaida> reviewEncontrado =  this.reviewService.getAllReviews(pageable).toList();
            
    //     assertTrue(reviewEncontrado.isEmpty());
    // }
        
    // @Test
    // void testGetAllReviewsNotEmpty() {

    //     this.createReview(
    //         new ReviewDtoEntrada(7, "foda", "03/05/01", "3ds", 25f, "213612763971"));
        
    //     this.createReview(
    //         new ReviewDtoEntrada(7, "foda", "03/05/01", "3ds", 25f, "213612763971"));

    //     this.createReview(
    //         new ReviewDtoEntrada(7, "foda", "03/05/01", "3ds", 25f, "213612763971"));


    //     Pageable pageable= PageRequest.of(0, 5);

    //     List<ReviewDtoSaida> reviewEncontrado =  this.reviewService.getAllReviews(pageable).toList();
            
    //     assertFalse(reviewEncontrado.isEmpty());
    // }

    // @Test
    // void testGetReviewbyIdSucess() {
    //     // adicionando o resultado esperado no Banco Mockado
    //     ReviewDtoSaida reviewEsperado = this.createReview(
    //         new ReviewDtoEntrada(7, "foda", "03/05/01", "3ds", 25f, "213612763971"));

    //     ReviewDtoSaida reviewDtoSaida =  this.reviewService.getReviewbyId(reviewEsperado.reviewId());
        
    //     assertThat(reviewDtoSaida).isEqualTo(reviewEsperado);
    // }

    // @Test
    // void testUpdateById() {
    //     // adicionando o resultado esperado no Banco Mockado
    //     ReviewDtoSaida reviewCriado = this.reviewService.createReview(
    //         new ReviewDtoEntrada(7, "foda", "03/05/01", "3ds", 25f, "213612763971"));

    //     ReviewDtoSaida reviewSaida = this.reviewService.getReviewbyId(reviewCriado.reviewId());    
    
    //     assertNotNull(reviewSaida);
    //     assertThat(reviewCriado).isEqualTo(reviewSaida);
        
    //     ReviewDtoPut update = new ReviewDtoPut(10, null, null, null, 0);

    //     this.reviewService.updatebyID(reviewCriado.reviewId(), update);

    //     reviewSaida = this.reviewService.getReviewbyId(reviewCriado.reviewId());
        
    //     assertTrue(reviewSaida.score() == 10);

    // } 
    
    private ReviewDtoSaida createReview(ReviewDtoEntrada dados){
        Review newReview = new Review(dados);
        entityManager.persist(newReview);
        return new ReviewDtoSaida(newReview);
    }
}
