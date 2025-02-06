package octodevs.gamevault.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class User {

    @Id
    private Long userId;
    private String login;
    private String password;

    public User() {
    }
}
