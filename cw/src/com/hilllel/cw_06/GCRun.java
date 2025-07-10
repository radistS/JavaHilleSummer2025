package com.hilllel.cw_06;

public class GCRun {
    public static void main(String[] args) {

        int i = 0;

        while (true) {
            System.out.println("create user >>  " + i);
            new Person("User " + i++);
        }

    }
}
