package com.hilllel.cw_24.i18n;

import static java.time.Instant.*;

import java.time.Instant;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TestInstant {

//    private static final String PATTERN_FORMAT = "dd.MM.yyyy HH:mm:ss";
    private static final String PATTERN_FORMAT = "dd MMM yy HH:mm";

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_FORMAT)
                .withZone(ZoneId.systemDefault());

        Instant instant = now();

        String formattedInstant = formatter.format(instant);

        System.out.println(formattedInstant);

        Instant plus5day = instant.plus(Period.ofDays(6));

        formattedInstant = formatter.format(plus5day);

        System.out.println(formattedInstant);

        Instant firstDayOfMonth = now().plus(Period.ofDays(6)).truncatedTo(ChronoUnit.DAYS).atZone(ZoneOffset.UTC).
                with(TemporalAdjusters.firstDayOfMonth()).toInstant();

        formattedInstant = formatter.format(firstDayOfMonth);

        System.out.println(formattedInstant);

        System.out.println("-------");

    }

}
