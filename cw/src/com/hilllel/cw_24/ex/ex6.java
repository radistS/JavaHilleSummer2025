package com.hilllel.cw_24.ex;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ex6 {
    public static void main(String[] args) {
        System.out.println(0.3 == 0.2 + 0.1);
        System.out.println(0.2 + 0.1);
        System.out.println(0.3 / (0.2 + 0.1));

        BigDecimal a1 = BigDecimal.valueOf(0.04d);
        BigDecimal a2 = BigDecimal.valueOf(0.04d);
        System.out.println(a1.divide(a2));

        System.out.println(0.11 / 0.11);

        double d = 0.3;
        System.out.println(d /d);

        System.out.println("-------------");

        BigDecimal res;
        String input1
                = "31452678569.2547534";

        // Convert the string input to BigDecimal
        BigDecimal a
                = new BigDecimal(input1);

        // Scale for BigDecimal
        int newScale = 4;

        System.out.println(a);
        // Using setScale() method
        res = a.setScale(2, RoundingMode.HALF_UP);

        // Display the result in BigDecimal
        System.out.println(res);
    }
}
