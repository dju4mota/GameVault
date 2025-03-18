package octodevs.gamevault.repositories.dto;

import jakarta.validation.constraints.NotNull;

public record GameDtoEntrada(
        @NotNull
        String title,
        String description,
        String genre
) {
}
