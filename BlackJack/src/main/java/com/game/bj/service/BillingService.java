package com.game.bj.service;

import com.game.bj.dto.Amount;
import com.game.bj.exceptions.NotEnoughtMoneyException;
import java.util.Scanner;

public class BillingService {

    public int validateAmount(Amount amount, int bet, Scanner sc) {
        if (amount.getAmount() <= 0){
            throw new NotEnoughtMoneyException("game over .. RIP");
        }
        if (bet > amount.getAmount()){
            try {
                System.out.printf("You can put %s %s. Continue [Y/N]%n", amount.getAmount(), amount.getCurrency());
                String input = sc.nextLine();

                if (!input.equalsIgnoreCase("y")){
                    System.out.printf("Please put your bet less than %s %s $%n", amount.getAmount(), amount.getCurrency());
                    bet = sc.nextInt();
                    sc.nextLine();
                    validateAmount(amount, bet, sc);
                } else {
                    bet = amount.getAmount();
                }
            } catch (NumberFormatException e) {

            }
        }
        return bet;
    }

    public void addAmount(Amount amount, int bet) {
        amount.setAmount(amount.getAmount() + bet); //
    }

    public void subtractAmount(Amount amount, int bet) {
        amount.setAmount(amount.getAmount() - bet);
    }
}


/*
 100
 1 - bet 25 + win 25
 win - 125
 lose - 100 -25 -> 75
 */
