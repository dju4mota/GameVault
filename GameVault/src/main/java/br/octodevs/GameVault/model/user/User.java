package br.octodevs.GameVault.model.user;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String password;
    private String userName;

    public User() {
    }

    public User(UserDTO_Entrada user) {
        this.password = user.password();
        this.userName = user.userName();
    }
}
