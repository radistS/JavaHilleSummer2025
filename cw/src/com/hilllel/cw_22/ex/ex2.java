package com.hilllel.cw_22.ex;

public class ex2 {
    public static void main(String[] args) {
        try {
            foo();
        } catch (Exception ex) {
            System.err.println("exMain");
            ex.printStackTrace();
        }
    }

    public static void foo() {
        try {
            throw new IllegalArgumentException("catch");
        } finally {
            try {
                throw new RuntimeException("finally");
            } catch (RuntimeException ex) {
                System.err.println("exFoo");
                ex.printStackTrace();
            }
        }
    }
}
