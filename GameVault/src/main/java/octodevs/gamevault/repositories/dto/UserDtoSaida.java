package octodevs.gamevault.repositories.dto;

import java.util.ArrayList;
import java.util.UUID;


public record UserDtoSaida(
        UUID userId,
        String login,
        String password,
        String profilePciture,
) {

    

}
