package octodevs.gamevault.repositories.dto.game;

import jakarta.validation.constraints.NotNull;

public record GameDtoEntrada(
        @NotNull
        String title,
        @NotNull
        String description,
        @NotNull
        String genre,
        @NotNull
        String photo
) {
}
