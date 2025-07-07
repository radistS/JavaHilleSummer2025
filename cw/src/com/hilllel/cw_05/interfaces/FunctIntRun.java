package com.hilllel.cw_05.interfaces;

public class FunctIntRun {

    public static void main(String[] args) {
        FunctInt fi = (srt) -> {
            System.out.println(srt.toUpperCase());
            System.out.println(srt.toUpperCase());
            System.out.println(srt.toUpperCase());
            System.out.println(srt.toUpperCase());

        };
        fi.print("aaaa");
        fi.print("bbbb");
        fi.print("cccc");
        fi.print("ssss");
        fi = (str) -> System.out.println("new version");

        fi.print("aaa");
        print("ssss");
    }

    public static void print(String str1) {
        FunctInt fi = (str) -> System.out.println("new version method");
        fi.print(str1);
    }
}
