package octodevs.gamevault.repositories.dto;

import java.util.UUID;

public record UserDtoEntrada (
    UUID userId,
    String login,
    String password,
    String profilePciture

) {
}
