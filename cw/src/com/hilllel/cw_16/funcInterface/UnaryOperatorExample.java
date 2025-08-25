package com.hilllel.cw_16.funcInterface;

import java.util.function.UnaryOperator;
/*
    Представляє бінарний оператор, тобто функцію, яка приймає два аргументи та повертає значення того ж типу.
 */
public class UnaryOperatorExample {

    public static void main(String[] args) {
        UnaryOperator<Integer> doubleNumber = n -> n * 2;
        System.out.println("Double value: " + doubleNumber.apply(5));
    }

}
