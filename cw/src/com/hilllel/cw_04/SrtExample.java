package com.hilllel.cw_04;

public class SrtExample {
    public static void main(String[] args) {
        String srt1 = new String("1");
        String srt2 = new String("1");
        String srt3 = srt1;

        System.out.println(srt1 == srt2);
        System.out.println(srt1.equals(srt2));
        System.out.println(srt1 == srt3);

        srt1 = "2"; // new object

        System.out.println(srt1 == srt3);

        System.out.println(srt2);
        System.out.println(srt3);
        System.out.println(srt2 == srt3);
        System.out.println(srt2.equals(srt3));

        srt2 = srt2.intern(); // --> to StringPool
        srt3 = srt3.intern(); // --> to StringPool
        System.out.println(srt2);
        System.out.println(srt3);
        System.out.println(srt2 == srt3);

    }
}
