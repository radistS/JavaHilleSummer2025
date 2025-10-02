package com.hilllel.cw_24.i18n;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

public class DateFormater {
    public static void main(String[] args) {
        System.out.println("DE --------------------->");
        print("de");
        System.out.println("US --------------------->");
        print("us");
        System.out.println("UA --------------------->");
        print("UA");
        System.out.println("FR --------------------->");
        print("fr");
        System.out.println("IZ --------------------->");
        print("he");
//
//        ZoneId.getAvailableZoneIds().forEach(System.out::println);
//        LocalDateTime ldt = LocalDateTime.now();
//        System.out.println(ldt.atZone(ZoneId.of("US/Pacific")));
    }

    private static void print(String loc) {
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, new Locale(loc));
        System.out.println(df.format(new Date()));
        df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, new Locale(loc));
        System.out.println(df.format(new Date()));
        df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, new Locale(loc));
        System.out.println(df.format(new Date()));
        df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, new Locale(loc));
        System.out.println(df.format(new Date()));
    }
}


