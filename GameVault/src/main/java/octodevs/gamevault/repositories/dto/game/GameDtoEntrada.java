package octodevs.gamevault.repositories.dto.game;

import jakarta.validation.constraints.NotNull;

public record GameDtoEntrada(
        @NotNull
        String title,
        String description,
        String genre,
        String photo
) {
}
