package octodevs.gamevault.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import octodevs.gamevault.models.Review;
import octodevs.gamevault.repositories.dto.ReviewDtoSaida;
import octodevs.gamevault.repositories.dto.ReviewDtoEntrada;
import static org.assertj.core.api.Assertions.assertThat ;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.util.List;


//@SpringBootTest
// @ActiveProfiles("test")
// @Transactional
public class ReviewControllerTest {


    @Autowired
    ReviewController reviewController;

    @Autowired
    UriComponentsBuilder uriBuilder;

    @Autowired
    EntityManager entityManager;
       
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

//    @Test
//     public void testCreateReview() throws Exception {
//         // Arrange
//         ReviewDtoPost reviewDto = new ReviewDtoPost(7, "foda", "03/05/01", "3ds", 25f, "213612763971");
        
//         Long reviewId = 1L;
//         when(this.reviewController.createReview(any(ReviewDtoPost.class), uriBuilder)).thenReturn(ResponseEntity.created(null));

//         // Act & Assert
//         mockMvc.perform(MockMvcRequestBuilders
//                 .post("/reviews")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(objectMapper.writeValueAsString(reviewDto)))
//                 .andExpect(MockMvcResultMatchers.status().isCreated())
//                 .andExpect(MockMvcResultMatchers.header().exists("Location"))
//                 .andExpect(MockMvcResultMatchers.header().string("Location", "http://localhost/reviews/1"));
//     }


    // @Test
    // void testDeleteReviewById() {

    // }

    // @Test
    // void testGetAllReviewsSucess() {
        
    //     // adicionando o resultado esperado no Banco Mockado
        
    //     Review review = this.createReview(
    //         new ReviewDtoEntrada(7, "foda", "03/05/01", "3ds", 25f, "213612763971"));

    //     ReviewDtoSaida reviewEsperado = new ReviewDtoSaida(review);

    //     Pageable pageable= PageRequest.of(0, 5);

    //     List<ReviewDtoSaida> reviewEncontrado =  this.reviewController.getAllReviews(pageable).getBody().toList();
            
    //     assertThat(reviewEncontrado.get(0)).isEqualTo(reviewEsperado);
    // }
    
    // @Test
    // void testGetAllReviewsEmpty() {

    //     Pageable pageable= PageRequest.of(0, 5);

    //     List<ReviewDtoSaida> reviewEncontrado =  this.reviewController.getAllReviews(pageable).getBody().toList();
            
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

    //     List<ReviewDtoSaida> reviewEncontrado =  this.reviewController.getAllReviews(pageable).getBody().toList();
            
    //     assertFalse(reviewEncontrado.isEmpty());
    // }

    // // @Test
    // // void testGetReviewbyId() {

    // // }

    // // @Test
    // // void testUpdateById() {

    // // }
    
    // private Review createReview(ReviewDtoEntrada dados){
    //     Review newReview = new Review(dados);
    //     entityManager.persist(newReview);
    //     return newReview;
    // }
}
