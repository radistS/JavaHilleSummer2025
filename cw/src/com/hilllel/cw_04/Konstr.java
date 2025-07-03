package com.hilllel.cw_04;

public class Konstr {
    int a; // 0
    int b; // 0

    public Konstr() {
        System.out.println("default constructor");
    }

    public Konstr(int a) {
        System.out.println("konstr : a");
        this.a = a;
    }

    public Konstr(int a, int b) {
//        this(a);
        System.out.println("konstr : a, b ");
        this.b = b;
        this.a = a;
    }

    void printParam(){
        System.out.println("a = " + a + "; b = " + b);
    }
}
