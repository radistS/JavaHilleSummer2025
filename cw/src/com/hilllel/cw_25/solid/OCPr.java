package com.hilllel.cw_25.solid;

public class OCPr {

}

// Принцип відкритості/закритості: Класи повинні бути відкриті для розширення, але закриті для модифікації.
// Це означає, що ви можете додавати нову функціональність через розширення, але не змінюючи існуючий код.

abstract class Shape {
    public abstract double calculateArea();  // Абстрактний метод для розрахунку площі
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;  // Формула для обчислення площі кола
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;  // Формула для обчислення площі прямокутника
    }
}

// Пояснення:
// Нові фігури можна додавати шляхом створення нових класів (наприклад, Triangle),
// не змінюючи існуючі класи Circle або Rectangle.
