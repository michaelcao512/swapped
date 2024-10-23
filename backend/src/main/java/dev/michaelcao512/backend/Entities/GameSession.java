package dev.michaelcao512.backend.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
public class GameSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @Getter
    private List<Player> players = new ArrayList<>();

    public GameSession(){}

    public void addPlayer(Player player){
        players.add(player);
    }
}
