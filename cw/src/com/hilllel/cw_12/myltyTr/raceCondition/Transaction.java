package com.hilllel.cw_12.myltyTr.raceCondition;

public class Transaction {
    public static void main(String[] args) {
        Account account = new Account();
        Thread one = new Thread(account);
        Thread two = new Thread(account);
        one.setName("Kate");
        two.setName("Jon");
        one.start();
        two.start();
    }
}
