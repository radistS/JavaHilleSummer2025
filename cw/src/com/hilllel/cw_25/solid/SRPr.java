package com.hilllel.cw_25.solid;

import java.util.List;

public class SRPr {

    public static void main(String[] args) {

    }

}

// Принцип єдиної відповідальності: Клас повинен мати тільки одну причину для зміни.
// Це означає, що кожен клас повинен виконувати одну чітко визначену задачу.

class Invoice {
    private List<OrderItem> items;

    // Цей метод відповідає тільки за обчислення загальної вартості замовлення
    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
}

class InvoicePrinter {
    // Цей метод відповідає тільки за друк рахунку
    public void printInvoice(Invoice invoice) {
        System.out.println("Загальна сума рахунку: " + invoice.calculateTotal());
    }
}

// Пояснення:
// Клас Invoice відповідає за обчислення вартості замовлення, а клас InvoicePrinter — за друк рахунку.
// Це дотримується принципу єдиної відповідальності, оскільки кожен клас має свою чітку задачу.

class OrderItem{
    int quantity;
    int price;

    public OrderItem(int quantity, int price) {
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }
}
