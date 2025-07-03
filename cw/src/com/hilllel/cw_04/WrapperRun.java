package com.hilllel.cw_04;

public class WrapperRun {
    public static void main(String[] args) {

        Wrapper w = new Wrapper();

        System.out.println(w.toString());

        w.i = 10;
        int a = w.i;
        System.out.println(a);

        Integer b = w.in; // 0
        System.out.println(b);

        w.b = true;
        boolean c = w.b;
        System.out.println(c);

        Boolean d = w.boll;
        System.out.println(d);

    }
}
