package octodevs.gamevault.repositories.dto;


import octodevs.gamevault.models.Review;


public record ReviewDtoSaida(
        String reviewId,
        int score,
        String comment,
        String data,
        String platform,
        float hoursPlayed,
        String gameId,
        String userId
) {
    public ReviewDtoSaida(Review review) {
        this(review.getReviewId(), review.getScore(), review.getComment(), review.getData(), review.getPlatform(), review.getHoursPlayed(),review.getGameId(),review.getUserId() );
    }

    public String reviewId() {
        return reviewId;
    }

    
}
