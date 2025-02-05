package octodevs.gamevault.crud;

import octodevs.gamevault.controllers.ReviewController;
import octodevs.gamevault.dto.DtoGetReview;
import octodevs.gamevault.models.Review;
import octodevs.gamevault.services.JsonFileReader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class RequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private ReviewController controller;
    @Autowired
    private ReviewController reviewController;
    @Autowired
    private JsonFileReader reader;

    @Test
    void getAllReviewsNotEmpty() {
        ResponseEntity<Stream<DtoGetReview>> response =  reviewController.getAllReviews(Pageable.unpaged());

        assertThat(response.getBody()).isNotNull();
        //assertThat(response.getBody().count()).isEqualTo(20);
    }

//    @Test
//    void getAllReviewsContent(){
//
//        List<Review> reviews = reader.readArrayReviewFromJson();
//        Stream<DtoGetReview> expected = reviews.stream().map(DtoGetReview::new);
//
//        ResponseEntity<Stream<DtoGetReview>> response =  reviewController.getAllReviews(Pageable.unpaged());
//
////        System.out.println("body:" + Objects.requireNonNull(response.getBody()).toList());
////        System.out.println("json"+ expected.toList());
//
//        assertThat(Objects.requireNonNull(response.getBody()).toList()).isEqualTo(expected.toList());
//    }


}