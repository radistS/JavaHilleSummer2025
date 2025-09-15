package org.example;

import java.lang.reflect.Field;

/**
 * This Java program demonstrates how to modify the internal state of a String object using reflection.
 *
 * @author  Oleksandr Stepurko
 * @version 0.0.3
 * @since 11.09.2025
 */
public class Run {

    /**
     * Entry point for the application.
     *
     * @param args arguments for application
     */

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        String str = "text";
        System.out.println(str);
        Class fn = str.getClass();
        Field field = fn.getDeclaredField("value");
        field.setAccessible(true);
        field.set(str, "WTF".toCharArray());
        System.out.println(str);
    }
}
