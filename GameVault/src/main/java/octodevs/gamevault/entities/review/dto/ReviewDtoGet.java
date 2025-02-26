package octodevs.gamevault.entities.review.dto;

import octodevs.gamevault.entities.review.Review;

import java.util.UUID;


public record ReviewDtoGet(
        UUID reviewId,
        int score,
        String comment,
        String data,
        String platform,
        float hoursPlayed,
        UUID gameId
) {
    public ReviewDtoGet(Review review) {
        this(review.getReviewId(), review.getScore(), review.getComment(), review.getData(), review.getPlatform(), review.getHoursPlayed(),review.getGameId() );
    }

}
