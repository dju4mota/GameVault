package octodevs.gamevault.models;


import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import octodevs.gamevault.repositories.dto.user.UserDtoEntrada;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;
    private String userName;
    private ArrayList<String> reviewsIds;
    private ArrayList<String> gamesList;
    private ArrayList<String> friends;
    private String password;
    private String profilePicture;
    
    @ElementCollection(fetch = FetchType.EAGER)
    private List<GrantedAuthority> authorities = new ArrayList<>();

    public UserAccount() {
    }

    public UserAccount(UserDtoEntrada dtoEntrada){ 
        this.userName = dtoEntrada.userName();
        this.password = dtoEntrada.password();
        this.profilePicture = dtoEntrada.profilePicture();
        this.reviewsIds = new ArrayList<String>();
        this.friends = new ArrayList<String>();
        this.gamesList = new ArrayList<String>();

    }

    

    public UserAccount(String userId, String userName, String password, String profilePicture) {
        this.userId = userId;
        this.userName = userName;
        this.reviewsIds = new ArrayList<String>();
        this.friends = new ArrayList<String>();
        this.gamesList = new ArrayList<String>();
        this.password = password;
        this.profilePicture = profilePicture;
    }



    public UserDetails asUser() {
        return User.withDefaultPasswordEncoder() //
            .username(getUserName()) //
            .password(getPassword()) //
            .authorities(getAuthorities()) //
            .build();
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

    public ArrayList<String> getReviewsIds() {
        return reviewsIds;
    }


    public ArrayList<String> getGamesList() {
        return gamesList;
    }


    public ArrayList<String> getFriends() {
        return friends;
    }

    public void addReview(String reviewId){
        if(reviewsIds == null){
            reviewsIds = new ArrayList<String>();            
        }
        reviewsIds.add(reviewId);
    }

    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }
    
}
