package com.game.bj.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Card {
    private Suit suit;
    private Rank rank;

    public int getCost(){
        return rank.getCost();
    }

    @Override
    public String toString() {
        return String.format("%s%s", rank.getName(), suit.getSymbol());
    }

}
