package octodevs.gamevault.entities.game.dto;

import octodevs.gamevault.entities.game.Game;


public record DtoGetGame(

        String title,
        String description,
        String genre
) {

    public DtoGetGame(Game game)
    {
        this(game.getTitle(), game.getDescription(), game.getGenre());
    }
}
