package com.hilllel.cw_03;

public class ForExample {
    private static final String HELLO = "Hello world"; // const

    public static void main(String[] args) {
        print(HELLO);
    }

    static void print(String str) {
        char[] s = str.toCharArray();

        int[] m = new int[str.length()];

//         index iteration
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + " ");
        }

        System.out.println();
//         for-each
        for (char c : s)
            System.out.print(c);
//
//        for (int i = 0, j = 0; i < s.length || j < m.length; i++, j++) {
//            m[i] = i + j;
//            System.out.print(i + j + " ");
//        }

//        System.out.println();
//
//        for (int t : m) {
//            System.out.print(t + " ");
//        }
    }
}
