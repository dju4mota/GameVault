package octodevs.gamevault.dto;

import octodevs.gamevault.dto.game.DtoPostGame;
import octodevs.gamevault.models.Game;

public record DtoPostReview(
        long reviewId,
        int score,
        String comment,
        String data,
        String platform,
        float hoursPlayed,
        DtoPostGame game
)
    {

    }
