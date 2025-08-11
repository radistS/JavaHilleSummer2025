package com.game.bj.service;

import static org.junit.jupiter.api.Assertions.*;

import com.game.bj.dto.Card;
import com.game.bj.exceptions.DeckException;
import java.util.Stack;
import org.junit.jupiter.api.Test;

public class DeckServiceTest {

    @Test
    public void createDeckTest_OK() {
        DeckService ds = new DeckService();
        ds.createDeck(1);
        assertEquals(52, ds.getDeck().size());

        ds.createDeck(2);
        assertEquals(104, ds.getDeck().size());
    }

    @Test
    public void createDeckTest_EXCEPTION() {
        DeckService ds = new DeckService();
        assertThrows(DeckException.class, () -> ds.createDeck(0));
        assertThrows(DeckException.class, () -> ds.createDeck(9));
        assertDoesNotThrow(() -> ds.createDeck(5));

    }

    @Test
    public void getDeckTest() {
        DeckService ds = new DeckService();
        ds.createDeck(1);
        assertTrue(ds.getDeck() instanceof Stack<Card>);
    }

    @Test
    public void getCardCountTest() {
        DeckService ds = new DeckService();
        ds.createDeck(1);
        assertEquals(52, ds.getCardCount());

        ds.dealCard();
        assertEquals(51, ds.getCardCount());
    }

    @Test
    public void dealCardTest() {
        DeckService ds = new DeckService();
        ds.createDeck(1);
        ds.dealCard();

    }
}
