package com.hilllel.cw_04;

public class Main {
    public static void main(String[] args) {
        Clazz c1 = new Clazz();
        Clazz c2 = new Clazz(14);

        System.out.println(c1.value);
        System.out.println(c2.value);

        System.out.println("-----");
        c1.value = 15;
        System.out.println(c1.value);
        System.out.println(c2.value);
        System.out.println("-----");
        c1.value = 20;
        c2.value = 20;
        System.out.println(c1.value);
        System.out.println(c2.value);

        System.out.println("--------");
        System.out.println(c1.getIndex());
        System.out.println(c2.getIndex());
        c1.setIndex(33);
        System.out.println(c1.getIndex());
        System.out.println(c2.getIndex());

        Clazz c3 = new Clazz();
        System.out.println(c1.getIndex());
        System.out.println(c2.getIndex());
        System.out.println(c3.getIndex());

        c3.setIndex(123);
        System.out.println(c1.getIndex());
        System.out.println(c2.getIndex());
        System.out.println(c3.getIndex());

    }
}
