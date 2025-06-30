package com.hilllel.cw_03.operators;

public class LogOper {

    public static void main(String[] args) {
        LogOper logOper = new LogOper();

        /*
        AND (&, &&)
        T & F -> F
        F & F -> F
        T & F -> F
        T & T -> T


        OR (|, ||)
        T | F -> T
        F | F -> F
        T | F -> T
        T | T -> T

         */

        System.out.println(logOper.isLeapYearUpd(2025)); // (T && T) -> T
    }
    public boolean isLeapYearUpd(int year){
        return (mod4(year) && mod100(year)) || (mod400(year));
    }

    private boolean mod4(int year){
        System.out.println("mod4");
        return year % 4 == 0;
    }

    private boolean mod100(int year){
        System.out.println("mod100");
        return year % 100 != 0;
    }

    private boolean mod400(int year){
        System.out.println("mod400");
        return year % 400 == 0;
    }
}
