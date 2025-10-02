package com.hilllel.cw_24.i18n;

import java.text.DateFormat;
import java.util.Locale;

public class SystemLocale {
    public static void main(String[] args) {
        Locale[] supportedLocales = DateFormat.getAvailableLocales();

        Locale curr = Locale.getDefault();

        System.out.println(curr.getCountry());
        System.out.println(curr.getLanguage());
        System.out.println("=============");
        Locale.setDefault(Locale.CANADA_FRENCH);
        curr = Locale.getDefault();
        System.out.println(curr.getCountry());
        System.out.println(curr.getLanguage());

        System.out.println("----------");

        for (Locale locale : supportedLocales){
            System.out.println(locale.getDisplayName());
        }
    }
}
