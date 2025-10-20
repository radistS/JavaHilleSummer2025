package com.hilllel.cw_30.ex;

public class Test1 {
    static boolean foo (String c) {
        System.out.println(c);
        return true;
    }

    public static void main(String[] args) {
        int i = 0;
        for (foo("init"); foo("check") && (i < 3); foo("incr")) {
            i++;
            foo("do");
        }
    }
}
