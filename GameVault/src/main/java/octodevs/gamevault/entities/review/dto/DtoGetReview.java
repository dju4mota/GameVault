package octodevs.gamevault.entities.review.dto;

import octodevs.gamevault.entities.game.dto.DtoGetGame;
import octodevs.gamevault.entities.review.Review;


public record DtoGetReview(
        long reviewId,
        int score,
        String comment,
        String data,
        String platform,
        float hoursPlayed,
        DtoGetGame game
) {
    public DtoGetReview(Review review) {
        this(review.getReviewId(), review.getScore(), review.getComment(), review.getData(), review.getPlatform(), review.getHoursPlayed(),new DtoGetGame(review.getGame()));
    }

}
