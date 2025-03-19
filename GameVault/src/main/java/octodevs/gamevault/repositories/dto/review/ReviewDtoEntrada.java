package octodevs.gamevault.repositories.dto.review;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


public record ReviewDtoEntrada(
        @NotNull
        int score,
        String comment,
        @NotNull
        String data,
        @NotNull
        String platform,
        @NotNull
        float hoursPlayed,
        @NotNull
        String gameId,
        @NotNull
        String userId
)
{}
