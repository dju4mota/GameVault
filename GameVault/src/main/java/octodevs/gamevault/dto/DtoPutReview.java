package octodevs.gamevault.dto;

import octodevs.gamevault.models.Game;

public record DtoPutReview(
    long reviewId,
    int score,
    String comment,
    String data,
    String platform,
    float hoursPlayed,
    Game game
) { }
