package br.octodevs.GameVault.model.gameList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Entity
@Getter
@Setter
public class GameList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long GameListId;
    private String name;
    private ArrayList<Long> gamesList;
}
