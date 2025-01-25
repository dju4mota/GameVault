package octodevs.gamevault.dto.game;

import octodevs.gamevault.models.Game;

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
