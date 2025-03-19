package octodevs.gamevault.repositories.dto.review;

import octodevs.gamevault.repositories.dto.game.GameDtoSaida;
import octodevs.gamevault.repositories.dto.user.UserDtoOut;

public record ReviewDtoCompleteSaida(
    ReviewDtoSaida review,
    GameDtoSaida game,
    UserDtoOut user
) {

    //public ReviewDtoCompleteSaida(ReviewDtoSaida review, GameDtoSaida game, UserDtoOut user)    
}
