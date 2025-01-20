package octodevs.gamevault.dto;

public record DtoPostReview(
        long reviewId,
        int score,
        String comment,
        String data,
        String platform,
        float hoursPlayed
)
    {

    }
