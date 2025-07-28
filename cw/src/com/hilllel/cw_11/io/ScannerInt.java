package com.hilllel.cw_11.io;

import java.util.Scanner;

public class ScannerInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите значения...");

//        String str = sc.nextLine();
//
//        System.out.println(Integer.valueOf(str));


        if (sc.hasNextInt()){
            System.out.println(sc.nextInt());
        } else {
            System.out.println("не цифра...");
        }



    }
}
