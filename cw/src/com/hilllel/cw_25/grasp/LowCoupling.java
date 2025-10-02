package com.hilllel.cw_25.grasp;

import java.util.List;

public class LowCoupling {

}

// Принцип низької зв'язаності: Класи повинні мати мінімум залежностей один від одного,
// що спрощує їхню зміну та повторне використання.

class OrderLC {
    private List<OrderItem> items;  // Order має слабку залежність від OrderItem

    public OrderLC(List<OrderItem> items) {
        this.items = items;
    }

    // Order не потребує знати всі деталі про кожен OrderItem
    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
}

class OrderItemLC {
    private double price;
    private int quantity;

    public OrderItemLC(double price, int quantity) {
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
// Order не має сильних залежностей від деталей реалізації OrderItem,
// що дозволяє змінювати або повторно використовувати об'єкти без великої кількості змін в інших класах.
