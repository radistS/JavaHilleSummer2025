package com.hilllel.cw_08.enumer;

public class SearchSystemRun {
    public static void main(String[] args) {
        SearchSystem ss = SearchSystem.GOOGLE;

        System.out.println(ss.url());
        System.out.println(ss.country());
        System.out.println(ss.rating());


        ss = SearchSystem.valueOf("BING");
        System.out.println(ss.country());
        System.out.println(ss.url());
        System.out.println(ss.rating());

        System.out.println(ss);
    }
}
