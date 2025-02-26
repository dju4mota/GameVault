package octodevs.gamevault.entities.review.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ReviewDtoPost(
        @NotNull
        int score,
        String comment,
        @NotNull
        String data,
        String platform,
        @NotNull
        float hoursPlayed,
        @Valid
        UUID gameId
)
{}
