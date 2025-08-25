package com.hilllel.cw_16;

public class RandomGenerator {

    public static int getIntValue(int maxValue){
        return (int) (Math.random() * maxValue);
    }

    public static String getSringValue(int numberOfChar) {
//        return RandomStringUtils.randomAlphabetic(numberOfChar).toLowerCase();
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getIntValue(100));

        System.out.println(getSringValue(10));
        System.out.println(getSringValue(5));
        System.out.println(getSringValue(5));
        System.out.println(getSringValue(5));
        System.out.println(getSringValue(5));
    }
}


