package com.game.bj.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Player {
    private String name;
    private int numberOfGames = 0;
    private int numberOfWins = 0;
    @ToString.Exclude
    private List<Card> hand = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void incrementNumberOfGames() {
        numberOfGames++;
    }
    public void incrementNumberOfWins() {
        numberOfWins++;
    }
    public void clearHand(){
        hand.clear();
    }

}
