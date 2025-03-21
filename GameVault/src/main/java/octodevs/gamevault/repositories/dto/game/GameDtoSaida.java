package octodevs.gamevault.repositories.dto.game;

import java.util.ArrayList;
import octodevs.gamevault.models.Game;


public record GameDtoSaida(
        String gameId,
        String title,
        String description,
        String genre,        
        ArrayList<String> reviewsId,
        String photo
) {

    public GameDtoSaida(Game game)
    {
        this(game.getGameId(),game.getTitle(), game.getDescription(), game.getGenre(), game.getReviewsIds(), game.getPhoto());
    }
}
