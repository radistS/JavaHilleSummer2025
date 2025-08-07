package com.game.bj.dto;

public enum Suit {
    Hearts('♥'),
    Clubs('♣'),
    Spades('♠'),
    Diamonds('♦');

    private final char symbol;

    public char getSymbol() {
        return symbol;
    }

    Suit(char symbol){
        this.symbol = symbol;
    }
}
