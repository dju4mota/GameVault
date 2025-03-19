package octodevs.gamevault.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import octodevs.gamevault.repositories.dto.game.GameDtoSaida;
import octodevs.gamevault.repositories.dto.game.GameDtoSaidaReviews;
import octodevs.gamevault.repositories.dto.review.ReviewDtoSaida;
import octodevs.gamevault.repositories.dto.user.UserDtoOut;
import octodevs.gamevault.repositories.dto.user.UserDtoSaidaReviews;

@Service
public class CombinedSearchsService {

    @Autowired
    private ReviewService reviewService;
    @Autowired
    private GameService gameService;
    @Autowired
    private UserService userService;


    // get game by Id and all his Reviews
    public GameDtoSaidaReviews getGameAndReviewsById(String id) {       
        
        ArrayList<ReviewDtoSaida> listaReviews = new ArrayList<ReviewDtoSaida>();
        GameDtoSaida game = gameService.getGameById(id);

        for (String reviewId : game.reviewsId()) {
            listaReviews.add(reviewService.getReviewbyId(reviewId));
        }

        GameDtoSaidaReviews saida = new GameDtoSaidaReviews(game, listaReviews);
        return  saida;
    }

    // get user by Id and all his Reviews
    public UserDtoSaidaReviews getUserAndReviewsById(String id) {       
    
        ArrayList<ReviewDtoSaida> listaReviews = new ArrayList<ReviewDtoSaida>();
        UserDtoOut user = userService.getUserById(id);

        for (String reviewId : user.reviewsIds()) {
            listaReviews.add(reviewService.getReviewbyId(reviewId));
        }

        UserDtoSaidaReviews saida = new UserDtoSaidaReviews(user, listaReviews);
        return  saida;
    }
}
