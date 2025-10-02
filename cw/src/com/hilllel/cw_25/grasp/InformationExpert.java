package com.hilllel.cw_25.grasp;

import java.util.List;

public class InformationExpert {

}

// Принцип інформаційного експерта: Об'єкт, що володіє необхідною інформацією для виконання певного завдання,
// повинен нести відповідальність за це завдання.

class Order {
    private List<OrderItem> items;  // Список елементів замовлення

    // Метод для обчислення загальної вартості замовлення
    // Order володіє всією інформацією про елементи замовлення, тому він несе відповідальність за це
    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
}

class OrderItemIE {
    private double price;
    private int quantity;

    public OrderItemIE(double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

// Пояснення:
// Принцип інформаційного експерта стверджує, що об'єкт, який володіє необхідними даними (Order),
// повинен нести відповідальність за обчислення суми замовлення.
