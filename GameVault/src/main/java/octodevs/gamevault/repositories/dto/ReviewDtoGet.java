package octodevs.gamevault.repositories.dto;


import octodevs.gamevault.models.Review;


public record ReviewDtoGet(
        String reviewId,
        int score,
        String comment,
        String data,
        String platform,
        float hoursPlayed,
        String gameId
) {
    public ReviewDtoGet(Review review) {
        this(review.getReviewId(), review.getScore(), review.getComment(), review.getData(), review.getPlatform(), review.getHoursPlayed(),review.getGameId() );
    }

}
