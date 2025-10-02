package com.hilllel.cw_25.solid;

public class ISPr {

}

// Принцип розділення інтерфейсів: Краще мати кілька вузькоспеціалізованих інтерфейсів,
// ніж один загальний інтерфейс, який змушує реалізовувати непотрібні методи.

interface Printer {
    void printDocument();
}

interface Scanner {
    void scanDocument();
}

// Клас реалізує тільки потрібні методи з окремих інтерфейсів
class MultiFunctionPrinter implements Printer, Scanner {
    @Override
    public void printDocument() {
        System.out.println("Друк документа...");
    }

    @Override
    public void scanDocument() {
        System.out.println("Сканування документа...");
    }
}

// Пояснення:
// Ми використовуємо два окремі інтерфейси для друку та сканування,
// замість одного великого інтерфейсу, який міг би змусити нас реалізовувати непотрібні методи.
