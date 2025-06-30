package com.hilllel.cw_03;


public class WhileEx {
    public static void main(String[] args) {

        whileExample();
        System.out.println("-------");
        doWhileExample();
    }

    static void whileExample(){
        byte a = 10;
        byte result = 0;
        while (a < 10) { // false then nothing
            System.out.print (a++ + " ");
        }
    }

    static void doWhileExample(){
        byte a = 10;
        byte result = 0;
        do {
            System.out.print(a++ + " ");
        } while (a < 10); // --> false

    }
}
