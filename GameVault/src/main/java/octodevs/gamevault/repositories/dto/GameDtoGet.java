package octodevs.gamevault.repositories.dto;

import java.util.UUID;

import octodevs.gamevault.models.Game;


public record GameDtoGet(
        String gameId,
        String title,
        String description,
        String genre
) {

    public GameDtoGet(Game game)
    {
        this(game.getGameId(),game.getTitle(), game.getDescription(), game.getGenre());
    }
}
