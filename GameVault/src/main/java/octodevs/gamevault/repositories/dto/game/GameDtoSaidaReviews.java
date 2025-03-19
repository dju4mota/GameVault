package octodevs.gamevault.repositories.dto.game;

import java.util.ArrayList;

import octodevs.gamevault.repositories.dto.review.ReviewDtoSaida;

public record GameDtoSaidaReviews(
    GameDtoSaida game,
    ArrayList<ReviewDtoSaida> reviews
    
) {
    
}
