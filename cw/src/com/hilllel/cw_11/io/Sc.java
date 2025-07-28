package com.hilllel.cw_11.io;

import java.util.Scanner;

public class Sc {

    public static void main(String[] args) {
        Scanner sc = new Scanner("5, 6, sss, 5");
        sc.useDelimiter(", ");
        while (sc.hasNextLong()) {
            System.out.println(sc.hasNextLong());
            System.out.println(sc.next());
        }
    }
}

