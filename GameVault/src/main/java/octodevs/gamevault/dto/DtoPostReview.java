package octodevs.gamevault.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import octodevs.gamevault.dto.game.DtoPostGame;

public record DtoPostReview(
        @NotNull
        @NotBlank
        long reviewId,
        @NotNull
        @NotBlank
        int score,
        String comment,
        @NotNull
        @NotBlank
        String data,
        String platform,
        @NotNull
        @NotBlank
        float hoursPlayed,
        @Valid
        DtoPostGame game
)
{}
