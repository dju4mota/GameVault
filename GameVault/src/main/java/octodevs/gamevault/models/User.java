package octodevs.gamevault.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import octodevs.gamevault.repositories.dto.user.UserDtoEntrada;

import java.util.ArrayList;
import java.util.UUID;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;
    private String userName;
    private ArrayList<String> reviewsId;
    private ArrayList<String> gamesList;
    private ArrayList<String> friends;
    private String password;
    private String profilePicture;

    public User() {
    }


    public User(UserDtoEntrada dtoEntrada){ 
        this.userName = dtoEntrada.userName();
        this.password = dtoEntrada.password();
        this.profilePicture = dtoEntrada.profilePicture();
        this.reviewsId = new ArrayList<String>();
        this.friends = new ArrayList<String>();
        this.gamesList = new ArrayList<String>();

    }

    

    public User(String userId, String userName, ArrayList<String> reviewsId, ArrayList<String> gamesList,
            ArrayList<String> friends, String password, String profilePicture) {
        this.userId = userId;
        this.userName = userName;
        this.reviewsId = new ArrayList<String>();
        this.friends = new ArrayList<String>();
        this.gamesList = new ArrayList<String>();
        this.password = password;
        this.profilePicture = profilePicture;
    }


    public String getUserName() {
        return userName;
    }



    public String getUserId() {
        return userId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }


    public String getProfilePicture() {
        return profilePicture;
    
    }

    public ArrayList<String> getReviewsId() {
        return reviewsId;
    }


    public ArrayList<String> getGamesList() {
        return gamesList;
    }


    public ArrayList<String> getFriends() {
        return friends;
    }
    
}
