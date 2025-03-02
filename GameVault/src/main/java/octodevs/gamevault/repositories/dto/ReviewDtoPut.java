package octodevs.gamevault.repositories.dto;

import octodevs.gamevault.models.Game;

public record ReviewDtoPut(
    long reviewId,
    int score,
    String comment,
    String data,
    String platform,
    float hoursPlayed,
    Game game
) { }
