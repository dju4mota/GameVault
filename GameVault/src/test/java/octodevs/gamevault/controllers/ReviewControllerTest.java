package octodevs.gamevault.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;

import jakarta.persistence.EntityManager;
import octodevs.gamevault.models.Review;
import octodevs.gamevault.repositories.ReviewRepository;
import octodevs.gamevault.repositories.dto.ReviewDtoPost;

import static org.assertj.core.api.Assertions.assertThat ;

import org.h2.mvstore.Page;


@DataJpaTest
@ActiveProfiles("test")
public class ReviewControllerTest {


    @Autowired
    ReviewController reviewController;

    @Autowired
    EntityManager entityManager;


    @Test
    void testCreateReview() {

    }

    @Test
    void testDeleteReviewById() {

    }

    @Test
    void testGetAllReviews() {

    }

    @Test
    void testGetReviewbyId() {

    }

    @Test
    void testUpdateById() {

    }




    // Teste puramente didático pois testa a função do Spring
    @Test
    void saveAll(){
        Review reviewEsperado = this.createReview(
            new ReviewDtoPost(10, "foda", "03/05/01", "3ds", 25f, "213612763971"));

        
            
            // To Do como passar parametros para o get
        //Review reviewEncontrado =  this.reviewController.getAllReviews()) 
            
        //assertThat(reviewEncontrado).isEqualTo(reviewEsperado);

    }


    
    private Review createReview(ReviewDtoPost dados){
        Review newReview = new Review(dados);
        entityManager.persist(newReview);
        return newReview;
    }
}
