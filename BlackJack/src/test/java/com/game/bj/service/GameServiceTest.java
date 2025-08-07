package com.game.bj.service;

import static org.junit.jupiter.api.Assertions.*;

import com.game.bj.dto.Card;
import com.game.bj.dto.Rank;
import com.game.bj.dto.Suit;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class GameServiceTest {

    @RepeatedTest(10)
    void getComputerCount() {
        GameService gs = new GameService();
        int computerCount = gs.getComputerCount();
        System.out.println(computerCount);
        assertTrue(computerCount >= 17);
        assertTrue(computerCount <= 25);
    }

    @RepeatedTest(10)
    void testGetComputerCount() {
        GameService gs = new GameService();
        DeckService ds = new DeckService();
        ds.createDeck(1);
        List<Card> computerCount1 = gs.getComputerCount(ds.getDeck());
        assertTrue(computerCount1.size() <= 5);
        assertTrue(ds.getDeck().size() >= 47);

    }

    @Test
    public void testCalculateHandScore_noBlackJack() {
        List<Card> cards = new ArrayList<Card>();
        cards.add(new Card(Suit.Hearts, Rank.Five));
        cards.add(new Card(Suit.Clubs, Rank.Ace));

        GameService gs = new GameService();
        int handScore = gs.calculateHandScore(cards);
        assertTrue(handScore == 16);
    }

    @Test
    public void testCalculateHandScore_isBlackJack() {
        List<Card> cards = new ArrayList<Card>();
        cards.add(new Card(Suit.Hearts, Rank.Ace));
        cards.add(new Card(Suit.Clubs, Rank.Ace));

        GameService gs = new GameService();
        int handScore = gs.calculateHandScore(cards);
        assertTrue(handScore == 21);

    }

}
