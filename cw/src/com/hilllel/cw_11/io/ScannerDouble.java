package com.hilllel.cw_11.io;

import java.util.Scanner;

public class ScannerDouble {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите значения...");
        if (sc.hasNextDouble()){
            System.out.println(sc.nextDouble());
        } else {
            System.out.println("не цифра...");
        }

    }
}
