package com.hilllel.cw_24.gof.adapter;

interface PaymentProcessor { void pay(int cents); }

class LegacyGateway {
    void makePayment(double dollars) {
        System.out.println("Paid $" + dollars);
    }
}

class LegacyAdapter implements PaymentProcessor {
    private final LegacyGateway gateway = new LegacyGateway();
    public void pay(int cents) {
        double dollars = cents / 100.0;
        gateway.makePayment(dollars);
    }
}

public class AdapterDemo {
    public static void main(String[] args) {
        PaymentProcessor p = new LegacyAdapter();
        p.pay(2599); // Paid $25.99
    }
}

