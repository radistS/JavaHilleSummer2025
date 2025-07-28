package com.hilllel.cw_11;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScannerExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean correct;
        System.out.println("Введіль цифру: ");
        String s;
        Integer i;
        do {
//            try{
//                i = scanner.nextInt();
//                correct = true;
//            } catch (InputMismatchException ex){
//                System.out.println("Це не цифра. Введіть цифру знову");
//                correct = false;
//            }

            s = scanner.nextLine();
            correct = true;
            try {
                Double.parseDouble(s);
            } catch (NumberFormatException nfe) {
                System.out.println(s + " це не цифра. Введіть цифру знову");
                correct = false;
            }

        } while (!correct);
        System.out.println("Введіть імя ....");
        String name = scanner.nextLine();
        System.out.println(name);

    }

}
