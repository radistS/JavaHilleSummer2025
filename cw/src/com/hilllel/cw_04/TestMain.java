package com.hilllel.cw_04;

public class TestMain {
    public static void main(String[] args) {
        TestMain.printStatic("test");
        TestMain tm = new TestMain();
        tm.print("test");
    }

    private void print(String str){
        System.out.println("print from method");
    }

    private static void printStatic(String str){
        System.out.println("print static from method");
    }
}
