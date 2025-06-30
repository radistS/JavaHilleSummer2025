package com.hilllel.cw_03.operators;

import java.text.DecimalFormat;

public class RoundExample {
    public static void main(String[] args) {
        double number = 123.456789;
        String formatted = String.format("%.2f", number);
        System.out.println("Округлённое число: " + formatted);

        DecimalFormat df = new DecimalFormat("#.00");
        formatted = df.format(number);
        System.out.println("Округлённое число: " + formatted);
    }
}
