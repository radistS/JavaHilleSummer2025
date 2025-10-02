package com.hilllel.cw_25.grasp;

public class Polymorphism {

}

// Принцип поліморфізму: Замість умовних операторів (if/else) використовуйте поліморфізм для реалізації різних поведінок.

interface PaymentMethod {
    void pay(double amount);
}

class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Оплата " + amount + " через кредитну картку");
    }
}

class PayPalPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Оплата " + amount + " через PayPal");
    }
}

class OrderPoly {
    // Метод обробки платежу за допомогою поліморфізму
    public void processPayment(PaymentMethod paymentMethod, double amount) {
        paymentMethod.pay(amount);  // Виклик методу pay() без знання конкретної реалізації
    }
}

// Пояснення:
// Використовуючи інтерфейс PaymentMethod, ми можемо обробляти різні способи оплати (кредитна картка, PayPal)
// без використання умовних операторів, покладаючись на поліморфізм для вибору правильного способу оплати.
