package com.game.bj;

import com.game.bj.dto.Card;
import com.game.bj.dto.Player;
import com.game.bj.service.DeckService;
import com.game.bj.service.GameService;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Black Jack 2025");
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter your name: ");
        String name = sc.nextLine();
        System.out.println("Please enter number of games: ");
        int games = sc.nextInt();
        sc.nextLine();
        Player p = new Player(name);
        System.out.println(String.format("%s has played %d games", name, games));

        DeckService ds = new DeckService();
        ds.createDeck(1);

        GameService gs = new GameService();

        boolean nextCart = true;
        boolean nextGame = true;

        int gameNumber = 1;

        do {
            System.out.println(String.format("%s game from %s games", gameNumber, games));
            game(p, ds, gs, sc);
        } while (nextGame(gameNumber++, games, sc));

    }

    private static boolean nextGame(int gameNumber, int games, Scanner sc) {
        if (gameNumber != games) {
            System.out.println("Next game ... [Y/N]");
            String input = sc.nextLine().toUpperCase();
            if (input.equals("N"))
                return false;
            else if (input.equals("Y")){
                return true;
            }
        } else {
            return false;
        }
        return true;
    }

    private static void game(Player p, DeckService ds, GameService gs, Scanner sc) {
        String nextCard;
        p.clearHand();
        do {
            List<Card> hand = p.getHand();
            // first time give 2 card
            if (hand.isEmpty()) {
                hand.add(ds.dealCard());
            }
            hand.add(ds.dealCard());
            int score = gs.calculateHandScore(hand);
            System.out.println("player hand : " + hand + " >>>> score : " + score);
            if (score < 21) {
                System.out.println("Next card ... [Y/N]");
                nextCard = sc.nextLine().toLowerCase();
            } else {
                break;
            }
        } while (nextCard.equals("y"));



    }
}
