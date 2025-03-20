package octodevs.gamevault.repositories.dto.review;

import octodevs.gamevault.repositories.dto.game.GameDtoSaida;
import octodevs.gamevault.repositories.dto.user.UserDtoOut;


/**
* Record para saída com Review + Game + User
*/
public record ReviewDtoCompleteSaida(
    ReviewDtoSaida review,
    GameDtoSaida game,
    UserDtoOut user
) {

}
