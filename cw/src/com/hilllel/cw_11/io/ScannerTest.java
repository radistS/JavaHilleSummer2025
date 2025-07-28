package com.hilllel.cw_11.io;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner("Hello, world, Hello world, Hello wor, ld ");
        sc.useDelimiter(", ");
        while (sc.hasNext()){
//            System.out.println(sc.next().trim());
            System.out.println(sc.next());
        }
    }
}
