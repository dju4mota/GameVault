package octodevs.gamevault.entities.review.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import octodevs.gamevault.entities.game.dto.DtoPostGame;

public record DtoPostReview(
        @NotNull
        long reviewId,
        @NotNull
        int score,
        String comment,
        @NotNull
        String data,
        String platform,
        @NotNull
        float hoursPlayed,
        @Valid
        DtoPostGame game
)
{}
