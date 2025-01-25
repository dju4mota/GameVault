package octodevs.gamevault.dto.game;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DtoPostGame(
        @NotNull
        @NotBlank
        String title,
        String description,
        String genre
) {
}
