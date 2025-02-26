package octodevs.gamevault.entities.game.dto;

import octodevs.gamevault.entities.game.Game;

import java.util.UUID;


public record GameDtoGet(
        UUID gameID,
        String title,
        String description,
        String genre
) {

    public GameDtoGet(Game game)
    {
        this(game.getGameId(),game.getTitle(), game.getDescription(), game.getGenre());
    }
}
