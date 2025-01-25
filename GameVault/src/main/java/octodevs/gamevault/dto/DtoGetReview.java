package octodevs.gamevault.dto;

import octodevs.gamevault.dto.game.DtoGetGame;
import octodevs.gamevault.models.Game;
import octodevs.gamevault.models.Review;

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
