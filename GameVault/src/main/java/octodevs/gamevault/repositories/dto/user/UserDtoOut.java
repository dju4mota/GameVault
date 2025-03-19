package octodevs.gamevault.repositories.dto.user;

import java.util.ArrayList;
import java.util.UUID;

import octodevs.gamevault.models.User;

public record UserDtoOut(
    String userId,
    String userName,
    String password,
    String profilePciture,
    ArrayList<String> reviewsId,
    ArrayList<String> gameList,
    ArrayList<String> friends
) {
    public UserDtoOut(User user){
        this(user.getUserId(), user.getUserName(), user.getPassword(), user.getProfilePciture(), user.getReviewsId(),user.getGamesList(), user.getFriends());
    }
}
