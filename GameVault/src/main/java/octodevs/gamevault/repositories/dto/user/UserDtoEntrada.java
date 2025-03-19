package octodevs.gamevault.repositories.dto.user;

import jakarta.validation.constraints.NotNull;

public record UserDtoEntrada (
    @NotNull
    String userName,
    @NotNull
    String password,
    @NotNull
    String profilePicture

) {
}
