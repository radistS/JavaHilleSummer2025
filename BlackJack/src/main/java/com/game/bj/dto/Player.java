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
    private Amount amount;
    @ToString.Exclude
    private List<Card> hand = new ArrayList<>();

    public Player(String name, int createAmountValue) {
        this.name = name;
        this.amount = new Amount(createAmountValue);
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
