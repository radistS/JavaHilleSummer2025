package com.hilllel.cw_25.grasp;

import java.util.List;

public class HighCohesion {

}

// Принцип високої зв'язаності: Класи та методи повинні бути сконцентровані на виконанні однієї добре визначеної задачі.

class OrderHC {
    private List<OrderItem> items;

    public OrderHC(List<OrderItem> items) {
        this.items = items;
    }

    // Метод для обчислення загальної вартості замовлення — чітко визначена задача
    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    // Метод для додавання елементу в замовлення — чітко визначена задача
    public void addItem(OrderItem item) {
        items.add(item);
    }
}

class OrderItemHC {
    private double price;
    private int quantity;

    public OrderItemHC(double price, int quantity) {
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
// Клас Order має високу зв'язаність, оскільки всі його методи та властивості сфокусовані на роботі з замовленням.
// Це робить клас легко підтримуваним і зрозумілим.
