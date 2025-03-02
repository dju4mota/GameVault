package octodevs.gamevault.repositories.dto;

import jakarta.validation.constraints.NotNull;

public record GameDtoPost(
        @NotNull
        String title,
        String description,
        String genre
) {
}
