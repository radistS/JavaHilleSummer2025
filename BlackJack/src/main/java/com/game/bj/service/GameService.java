package com.game.bj.service;

import com.game.bj.dto.Card;
import com.game.bj.dto.GameResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class GameService {

    private List<Card> hand;

    public int getComputerCount(){
        return new Random().nextInt(17,  26);
    }

    public List<Card> getComputerCount(Stack<Card> deck){
        List<Card> cards = new ArrayList<Card>();
        int numberOfCard = new Random().nextInt(2, 6);
        for (int i = 0; i < numberOfCard; i++) {
            cards.add(deck.pop());
        }
        return cards;
    }

    public int calculateHandScore(List<Card> hand) {
        this.hand = hand;
        int score = 0;
        for (Card card : hand) {
            score +=card.getCost();
        }
         if (hand.size() == 2 && isBJ(score)){
             return 21;
         }
         return score;
    }

    private boolean isBJ(int score) {
        return score == 22;
    }

    public GameResult getGameResult(int pScore, int cScore) {
        if (pScore > 21 && cScore > 21) {
            return GameResult.LOSE;
        } else if (cScore > 21){
            return GameResult.PLAYER;
        } else if (pScore > 21) {
            return GameResult.COMPUTER;
        } else if (pScore > cScore){
            return GameResult.PLAYER;
        } else if (pScore < cScore){
            return GameResult.COMPUTER;
        } else
            return GameResult.DRAW;
    }
}
