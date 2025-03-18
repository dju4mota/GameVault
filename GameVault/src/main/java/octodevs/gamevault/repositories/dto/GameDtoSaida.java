package octodevs.gamevault.repositories.dto;

import java.util.ArrayList;
import octodevs.gamevault.models.Game;


public record GameDtoSaida(
        String gameId,
        String title,
        String description,
        String genre,
        ArrayList<String> reviewsId
) {

    public GameDtoSaida(Game game)
    {
        this(game.getGameId(),game.getTitle(), game.getDescription(), game.getGenre(), game.getReviewsIds());
    }
}
