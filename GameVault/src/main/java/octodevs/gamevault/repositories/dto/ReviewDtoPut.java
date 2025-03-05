package octodevs.gamevault.repositories.dto;


public record ReviewDtoPut(
    int score,
    String comment,
    String data,
    String platform,
    float hoursPlayed
) { }
