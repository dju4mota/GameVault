package octodevs.gamevault.entities.review.dto;

import octodevs.gamevault.entities.game.dto.GameDtoGet;
import octodevs.gamevault.entities.review.Review;


public record ReviewDtoGet(
        long reviewId,
        int score,
        String comment,
        String data,
        String platform,
        float hoursPlayed,
        GameDtoGet game
) {
    public ReviewDtoGet(Review review) {
        this(review.getReviewId(), review.getScore(), review.getComment(), review.getData(), review.getPlatform(), review.getHoursPlayed(),new GameDtoGet(review.getGame()));
    }

}
