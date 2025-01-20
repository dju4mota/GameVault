package octodevs.gamevault.dto;

import octodevs.gamevault.models.Review;

public record DtoGetReview(
        long reviewId,
        int score,
        String comment,
        String data
) {
    public DtoGetReview(Review review) {
        this(review.getReviewId(), review.getScore(), review.getComment(), review.getData());
    }

}
