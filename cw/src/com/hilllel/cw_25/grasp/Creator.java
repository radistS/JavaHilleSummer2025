package com.hilllel.cw_25.grasp;

import java.util.ArrayList;
import java.util.List;

public class Creator {

}

// Принцип створювача: Клас, що містить або використовує інший об'єкт, має бути відповідальним за його створення.

class OrderCreator {
    private List<OrderItem> items = new ArrayList<>();  // Список елементів замовлення

    // Метод, який створює і додає елемент замовлення до списку
    // Order несе відповідальність за створення OrderItem, оскільки він використовує його
    public void addItem(double price, int quantity) {
        OrderItem item = new OrderItem(price, quantity);
        items.add(item);
    }
}

class OrderItem {
    private double price;
    private int quantity;

    public OrderItem(double price, int quantity) {
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
// Відповідно до принципу створювача, клас Order, який містить і керує елементами замовлення,
// відповідає за створення об'єктів типу OrderItem.
