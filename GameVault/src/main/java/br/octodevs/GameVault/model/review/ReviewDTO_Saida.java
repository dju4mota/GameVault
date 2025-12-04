package br.octodevs.GameVault.model.review;

import br.octodevs.GameVault.utils.Platform;

public record ReviewDTO_Saida(
        Long reviewId,
        Long score,
        String comment,
        String data,
        Platform platform,
        Long gameId,
        Long userId,
        Float hoursPlayed
) {
    public ReviewDTO_Saida(Review review){
        this(review.getReviewId(), review.getScore(), review.getComment(), review.getData(), review.getPlatform(), review.getGameId(), review.getUserId(),
                review.getHoursPlayed());
    }
}
