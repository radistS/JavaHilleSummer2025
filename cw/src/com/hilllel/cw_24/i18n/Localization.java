package com.hilllel.cw_24.i18n;

import java.util.Locale;

public class Localization {
    public static void main(String[] args) {
        Locale defaultLocale = Locale.getDefault();
        System.out.println(defaultLocale.getDisplayLanguage());
        System.out.println(defaultLocale.getDisplayName());

        Locale locale = new Locale("ua", "UA");
        System.out.println(locale.getDisplayLanguage());
        System.out.println(locale.getDisplayName());

        Locale.setDefault(Locale.US);

        defaultLocale = Locale.getDefault();
        System.out.println(defaultLocale.getDisplayLanguage());
        System.out.println(defaultLocale.getDisplayName());

        Locale.setDefault(Locale.CHINESE);
        System.out.println(defaultLocale.getDisplayLanguage());
        System.out.println(defaultLocale.getDisplayName());

        Locale.setDefault(Locale.GERMANY);
        System.out.println(defaultLocale.getDisplayLanguage());
        System.out.println(defaultLocale.getDisplayName());

    }
}
