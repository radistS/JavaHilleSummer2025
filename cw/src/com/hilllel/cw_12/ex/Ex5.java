package com.hilllel.cw_12.ex;

public class Ex5 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("0123456789");
        sb.delete(2, 8); // [form 2 to 8)
        System.out.println(sb);
        sb.append("-").insert(2, "+");
        System.out.println(sb);
    }
}
