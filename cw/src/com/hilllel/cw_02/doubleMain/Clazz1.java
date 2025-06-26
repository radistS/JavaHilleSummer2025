package com.hilllel.cw_02.doubleMain;

public class Clazz1 {
    public static void main(String[] args) {
        System.out.println("run clazz1");
        Clazz2.print();
    }

    public static void print(){
        System.out.println("call method print from clazz1");
    }

}
