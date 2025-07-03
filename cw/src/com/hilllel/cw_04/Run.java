package com.hilllel.cw_04;

class TestClass {
    public static void printStatic() {
        System.out.println("hello world");
    }

     public static String printStaticStr() {
        return "hello world";
    }

     public  void print() {
        System.out.println("hello world");
    }

     public  String printStr() {
        return "hello world";
    }
}

public class Run {
    public static void main(String[] args) {
        // class
        TestClass.printStatic();
        System.out.println(TestClass.printStaticStr());

        //object
        TestClass tc = new TestClass();
        tc.print();
        System.out.println(tc.printStr());
    }
}
