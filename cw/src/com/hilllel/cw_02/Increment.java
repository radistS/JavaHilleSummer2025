package com.hilllel.cw_02;

public class Increment {
    public static void main(String[] args) {
        int i = 0;
        System.out.println(++i); // 1 -> 0 + 1 = 1  prefix +
        System.out.println(i++); // 1 -> 1 + 1 = 2  postfix +
        System.out.println(i);
        System.out.println(--i); // 1 -> 2 - 1 = 1  prefix -
        System.out.println(i--); // 1 -> 1 - 1 = 0  postfix -
        System.out.println(i);
    }
}
