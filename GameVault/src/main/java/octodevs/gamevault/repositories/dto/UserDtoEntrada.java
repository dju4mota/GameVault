package octodevs.gamevault.repositories.dto;

import java.util.ArrayList;

public record UserDtoEntrada (
    
    String userName,
    String password,
    String profilePciture,
    ArrayList<String> reviewsId,
    ArrayList<String> gameLists,
    ArrayList<String> friends

) {
}
