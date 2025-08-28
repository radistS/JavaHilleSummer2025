package com.hilllel.cw_17.funcInterface;

public class Run {

    public static void main(String[] args) {
        StringUpdater su = (str) -> str.toUpperCase();

        System.out.println(su.toUppercase("aaaa"));
        System.out.println(su.toUppercase("bbbb"));

        su = str -> new StringBuilder(str).reverse().toString();

        System.out.println(su.toUppercase("qwerty"));


    }

}
