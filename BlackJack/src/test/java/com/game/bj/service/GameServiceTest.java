package com.game.bj.service;

import static org.junit.jupiter.api.Assertions.*;

import com.game.bj.dto.Card;
import com.game.bj.dto.GameResult;
import com.game.bj.dto.Rank;
import com.game.bj.dto.Suit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class GameServiceTest {

    @RepeatedTest(10)
    public void getComputerCount() {
        GameService gs = new GameService();
        int computerCount = gs.getComputerCount();
        System.out.println(computerCount);
        assertTrue(computerCount >= 17);
        assertTrue(computerCount <= 25);
    }

    @RepeatedTest(10)
    public void testGetComputerCount() {
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

    @ParameterizedTest(name = "[{index}] p ={0}, c={1} => {2}")
    @CsvSource({
        // both bust
        "22,22,LOSE",
        "30,25,LOSE",

        // computer bust -> player wins
        "18,22,PLAYER",
        "21,99,PLAYER",

        // player bust -> computer wins
        "22,18,COMPUTER",
        "99,21,COMPUTER",

        // normal comparisons
        "20,19,PLAYER",
        "19,20,COMPUTER",
        "21,21,DRAW",

        // boundary checks around 21
        "21,22,PLAYER",
        "22,21,COMPUTER",
        "0,0,DRAW"
    })
    void testCalculateHandScore(int player, int computer, GameResult expected) {
        GameService gs = new GameService();
        assertEquals(expected, gs.getGameResult(player,computer));
    }

    @ParameterizedTest
    @MethodSource("points")
    void getGameResult(int computer, int player, GameResult expected) {
        GameService gs = new GameService();
        assertEquals(expected, gs.getGameResult(player, computer));
    }

    private static Stream<Arguments> points() {
        return Stream.of(
            Arguments.of(21, 21, GameResult.DRAW),
            Arguments.of(22, 22, GameResult.LOSE),
            Arguments.of(18, 22, GameResult.COMPUTER),
            Arguments.of(22, 18, GameResult.PLAYER),
            Arguments.of(18, 17, GameResult.COMPUTER),
            Arguments.of(14, 20, GameResult.PLAYER),
            Arguments.of(18, 18, GameResult.DRAW)
        );
    }

}
