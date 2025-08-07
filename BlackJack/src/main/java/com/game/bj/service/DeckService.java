package com.game.bj.service;

import com.game.bj.dto.Card;
import com.game.bj.dto.Rank;
import com.game.bj.dto.Suit;
import com.game.bj.exceptions.DeckException;
import java.util.Collections;
import java.util.Stack;
import lombok.SneakyThrows;

public class DeckService {
    private Stack<Card> deck = new Stack<Card>();

    @SneakyThrows
    public void createDeck(int decNumber)  {
        deck.clear();

        if (decNumber < 1 || decNumber > 8) {
            throw new DeckException("Number of deck must be between 1 and 8");
        }

        for (int i = 0; i < decNumber; i++) {
            for (Rank rank : Rank.values()) {
                for (Suit suit : Suit.values()) {
                    deck.add(new Card(suit, rank));
                }
            }
        }
        Collections.shuffle(deck);
    }

    public Stack<Card> getDeck() {
        return deck;
    }

    public int getCardCount() {
        return deck.size();
    }

    public Card dealCard() {
        return deck.pop();
    }
}
