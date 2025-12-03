package br.octodevs.GameVault.model.dto;

import br.octodevs.GameVault.model.Review;

public record ReviewDTO_Saida(
        Long id,
        Long score
) {
    public ReviewDTO_Saida(Review review){
        this(review.getReviewId(), review.getScore());
    }
}
