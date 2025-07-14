package com.hilllel.cw_07.str;

public class StrBuilder {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("QWERTY");
        System.out.println(sb.toString());
        sb.reverse();
        System.out.println(sb.toString());
        sb.setLength(4);
        System.out.println(sb);
        sb.append("edeee");
        System.out.println(sb.toString());
        sb.insert(5, "sdfsd");
        System.out.println(sb.toString());
        sb.insert(0, "     ");
        System.out.println(sb.toString());
        sb.setLength(4);
        System.out.println(sb.toString());
    }
}
