package octodevs.gamevault.repositories.dto;

import octodevs.gamevault.utils.UserRole;

public record RegisterDTO(String userName, String password, UserRole role){

}
