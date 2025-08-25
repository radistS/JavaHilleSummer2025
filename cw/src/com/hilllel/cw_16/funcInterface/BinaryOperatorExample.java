package com.hilllel.cw_16.funcInterface;

import java.util.function.BinaryOperator;
/*
    Представляє бінарний оператор, тобто функцію, яка приймає два аргументи та повертає значення того ж типу.
 */
public class BinaryOperatorExample {

    public static void main(String[] args) {
        BinaryOperator<Integer> max = Integer::max;
        System.out.println("Max: " + max.apply(7, 3));
    }

}
