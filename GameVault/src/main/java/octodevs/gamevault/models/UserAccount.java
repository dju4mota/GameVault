package octodevs.gamevault.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import octodevs.gamevault.repositories.dto.user.UserDtoEntrada;
import octodevs.gamevault.utils.UserRole;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class UserAccount implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;
    private String userName;
    private ArrayList<String> reviewsIds;
    private ArrayList<String> gamesList;
    private ArrayList<String> friends;
    private String password;
    private String profilePicture;
    private UserRole role;

    public UserAccount() {
    }

    public UserAccount(UserDtoEntrada dtoEntrada){ 
        this.userName = dtoEntrada.userName();
        this.password = dtoEntrada.password();
        this.profilePicture = dtoEntrada.profilePicture();
        this.reviewsIds = new ArrayList<String>();
        this.friends = new ArrayList<String>();
        this.gamesList = new ArrayList<String>();    
        this.role = UserRole.USER;    
    }
    public UserAccount(UserDtoEntrada dtoEntrada, String encryptedPassword){ 
        this.userName = dtoEntrada.userName();
        this.password = encryptedPassword;
        this.profilePicture = dtoEntrada.profilePicture();
        this.reviewsIds = new ArrayList<String>();
        this.friends = new ArrayList<String>();
        this.gamesList = new ArrayList<String>();    
        this.role = UserRole.USER;    
    }

    // public UserAccount(String userName, String password, UserRole role){
    //     this.userName = userName;
    //     this.password = password;
    //     this.role = role;
    // }

    public UserAccount(String userId, String userName, String password, String profilePicture, UserRole role) {
        this.userId = userId;
        this.userName = userName;
        this.reviewsIds = new ArrayList<String>();
        this.friends = new ArrayList<String>();
        this.gamesList = new ArrayList<String>();
        this.password = password;
        this.profilePicture = profilePicture;
        this.role = role;
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

    @Override
    public String getUsername() {
       return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return UserDetails.super.isEnabled();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ADMIN)
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else 
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }
    
    
}
