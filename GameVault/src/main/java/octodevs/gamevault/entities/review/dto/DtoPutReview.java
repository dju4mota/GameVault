package octodevs.gamevault.entities.review.dto;

import octodevs.gamevault.entities.game.Game;

public record DtoPutReview(
    long reviewId,
    int score,
    String comment,
    String data,
    String platform,
    float hoursPlayed,
    Game game
) { }
