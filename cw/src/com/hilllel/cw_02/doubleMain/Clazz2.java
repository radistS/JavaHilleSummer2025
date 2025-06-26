package com.hilllel.cw_02.doubleMain;

public class Clazz2 {
    public static void main(String[] args) {
        System.out.println("run clazz2");
        Clazz1.print();
    }

    public static void print(){
        System.out.println("call method print from clazz2");
    }
}
