package octodevs.gamevault.entities.game.dto;

import jakarta.validation.constraints.NotNull;

public record DtoPostGame(
        @NotNull
        String title,
        String description,
        String genre
) {
}
