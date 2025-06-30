package com.hilllel.cw_03.pack1;

public class Main {
    public static void main(String[] args) {
        Test1 t = new Test1();

        System.out.println("-----------");

        t.print(); // default
        t.printProtected(); // protected
        t.printPublic(); // public
    }
}
