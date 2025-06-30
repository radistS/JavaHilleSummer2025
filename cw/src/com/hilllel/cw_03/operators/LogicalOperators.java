package com.hilllel.cw_03.operators;

public class LogicalOperators {
    public static void main(String[] args) {
        boolean x = true;
        boolean y = false;

        // Оператор логічного І (AND)
        System.out.println("x && y: " + (x && y)); // false

        // Оператор логічного АБО (OR)
        System.out.println("x || y: " + (x || y)); // true
    }
}

/*
AND (&, &&)
T & F -> F
F & F -> F
T & F -> F
T & T -> T


OR (|, ||)
T | F -> T
F | F -> F
T | F -> T
T | T -> T

 */
