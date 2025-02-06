package octodevs.gamevault.entities.game.dto;

import octodevs.gamevault.entities.game.Game;


public record GameDtoGet(

        String title,
        String description,
        String genre
) {

    public GameDtoGet(Game game)
    {
        this(game.getTitle(), game.getDescription(), game.getGenre());
    }
}
