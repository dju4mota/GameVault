package octodevs.gamevault.repositories.dto;

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
        @Valid
        String gameId
)
{}
