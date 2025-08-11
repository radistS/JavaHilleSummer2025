package com.game.bj.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Amount {
    private int amount;
    private Currency currency;

    public Amount(int amount) {
        this.amount = amount;
        this.currency = Currency.USD;
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
