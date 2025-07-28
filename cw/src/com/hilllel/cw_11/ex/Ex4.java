package com.hilllel.cw_11.ex;

public class Ex4 {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("S1");
        StringBuilder sb2 = new StringBuilder("S2"); // + b
        StringBuilder sb3 = new Work().work(sb1, sb2); // S1  S2

        System.out.println("sb1 -> " + sb1);
        System.out.println("sb2 -> " + sb2);
        System.out.println("sb3 -> " + sb3);
    }
}

class Work {
    public StringBuilder work(StringBuilder a, StringBuilder b) { //s1, s2
        a = new StringBuilder("a");
        b.append("b");
        return a;
    }
}
