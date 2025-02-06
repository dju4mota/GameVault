package octodevs.gamevault.entities.user;


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
