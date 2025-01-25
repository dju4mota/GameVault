package octodevs.gamevault.dto;

public record DtoPutReview(
    long reviewId,
    int score,
    String comment,
    String data,
    String platform,
    float hoursPlayed
) { }
