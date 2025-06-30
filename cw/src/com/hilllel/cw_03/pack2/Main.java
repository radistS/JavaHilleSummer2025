package com.hilllel.cw_03.pack2;


import com.hilllel.cw_03.pack1.Test1;

public class Main {
    public static void main(String[] args) {
        Test1 t1 = new Test1();
        System.out.println("------------");
        t1.printPublic();

        System.out.println();

        Test2 t2 = new Test2();
        System.out.println("------------");
        t2.printPublic();
    }
}
