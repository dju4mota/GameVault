package octodevs.gamevault.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import octodevs.gamevault.dto.game.DtoPostGame;

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
