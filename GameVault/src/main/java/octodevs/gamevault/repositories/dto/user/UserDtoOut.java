package octodevs.gamevault.repositories.dto.user;

import java.util.ArrayList;

import octodevs.gamevault.models.UserAccount;

public record UserDtoOut(
    String userId,
    String userName,
    String password,
    String profilePicture,
    ArrayList<String> reviewsIds,
    ArrayList<String> gameList,
    ArrayList<String> friends
) {
    public UserDtoOut(UserAccount user){
        this(user.getUserId(), user.getUserName(), user.getPassword(), user.getProfilePicture(), user.getReviewsIds(),user.getGamesList(), user.getFriends());
    }
}
