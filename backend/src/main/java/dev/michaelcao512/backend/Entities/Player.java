package dev.michaelcao512.backend.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String name;
    @Getter @Setter
    private boolean eliminated;
    @Getter @Setter
    private int score;

    public Player(){}

    public  Player(String name){
        this.name = name;
        this.eliminated = false;
        this.score = 0;
    }


}