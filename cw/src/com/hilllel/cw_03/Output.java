package com.hilllel.cw_03;
public class Output {
    public static void main(String[] args) {
        calc(1,1);

        System.out.println(calcReturn(1, 2));

        print(calcReturn(1,2));
    }

    public static void calc(int a, int b){
        System.out.println(a + b);
    }

    public static int calcReturn(int a, int b){
        return a + b;
    }

    public static void print(Object obj) {
        System.out.println(obj);
    }
}
