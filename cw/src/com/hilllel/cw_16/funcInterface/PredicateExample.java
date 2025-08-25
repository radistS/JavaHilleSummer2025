package com.hilllel.cw_16.funcInterface;

import java.util.function.Predicate;
/*
    Представляє предикат (умову), який приймає аргумент типу T і повертає булеве значення.
 */
public class PredicateExample {

    public static void main(String[] args) {
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Value is odd: " + isEven.test(5));  // false
        System.out.println("Value is not odd: " + isEven.test(8));  // true
    }

}
