package octodevs.gamevault.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import octodevs.gamevault.models.Review;
import octodevs.gamevault.repositories.dto.ReviewDtoGet;
import octodevs.gamevault.repositories.dto.ReviewDtoPost;
import static org.assertj.core.api.Assertions.assertThat ;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class ReviewControllerTest {


    @Autowired
    ReviewController reviewController;

    @Autowired
    EntityManager entityManager;


    // @Test
    // void testCreateReview() {

    // }

    // @Test
    // void testDeleteReviewById() {

    // }

    @Test
    void testGetAllReviewsSucess() {
        
        // adicionando o resultado esperado no Banco Mockado
        
        Review review = this.createReview(
            new ReviewDtoPost(7, "foda", "03/05/01", "3ds", 25f, "213612763971"));

        ReviewDtoGet reviewEsperado = new ReviewDtoGet(review);

        Pageable pageable= PageRequest.of(0, 5);

        List<ReviewDtoGet> reviewEncontrado =  this.reviewController.getAllReviews(pageable).getBody().toList();
            
        assertThat(reviewEncontrado.get(0)).isEqualTo(reviewEsperado);
    }
    
    @Test
    void testGetAllReviewsEmpty() {

        Pageable pageable= PageRequest.of(0, 5);

        List<ReviewDtoGet> reviewEncontrado =  this.reviewController.getAllReviews(pageable).getBody().toList();
            
        assertTrue(reviewEncontrado.isEmpty());
    }
        
    @Test
    void testGetAllReviewsNotEmpty() {

        this.createReview(
            new ReviewDtoPost(7, "foda", "03/05/01", "3ds", 25f, "213612763971"));
        
        this.createReview(
            new ReviewDtoPost(7, "foda", "03/05/01", "3ds", 25f, "213612763971"));

        this.createReview(
            new ReviewDtoPost(7, "foda", "03/05/01", "3ds", 25f, "213612763971"));


        Pageable pageable= PageRequest.of(0, 5);

        List<ReviewDtoGet> reviewEncontrado =  this.reviewController.getAllReviews(pageable).getBody().toList();
            
        assertFalse(reviewEncontrado.isEmpty());
    }

    // @Test
    // void testGetReviewbyId() {

    // }

    // @Test
    // void testUpdateById() {

    // }
    
    private Review createReview(ReviewDtoPost dados){
        Review newReview = new Review(dados);
        entityManager.persist(newReview);
        return newReview;
    }
}
