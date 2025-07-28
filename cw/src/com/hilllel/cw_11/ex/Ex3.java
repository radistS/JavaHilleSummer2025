package com.hilllel.cw_11.ex;

public class Ex3 extends Ex3_1 {
    public void print(int d) {
        System.out.println("EX3");
    }

    public static void main(String[] args) {
        Ex3 ex = new Ex3();
        ex.print(1);
        ex.print(2.0);
    }
}

class Ex3_1 {
    public void print(double d) {
        System.out.println("EX3_1");
    }
}
