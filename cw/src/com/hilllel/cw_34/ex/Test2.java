package com.hilllel.cw_34.ex;

public class Test2 {
    public static void main(String[] args) {
        Test2 test = new Test2();
        test.print("C");
        Test2.print("C");
    }

    public void print() {
        System.out.println("A");
    }

    public static  void print(String s) {
        System.out.println("B");
    }
}
