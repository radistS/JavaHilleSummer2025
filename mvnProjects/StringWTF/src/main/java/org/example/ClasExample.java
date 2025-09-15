package org.example;

import java.lang.reflect.InvocationTargetException;

/**
 *  * This Java program demonstrates different ways to obtain a Class object
 *  * and create new instances of a class using reflection.
 *  * It shows how to get the Class object from an instance, by name,
 *  * and how to create new objects using the Class object.
 *  * @param args - arguments for application
 *
 * @author  Oleksandr Stepurko
 * @version 0.0.3
 * @since 11.09.2025
 *
 */

public class ClasExample {

    /**
     * This Java program demonstrates different ways to obtain a Class object
     * and create new instances of a class using reflection.
     * It shows how to get the Class object from an instance, by name,
     * and how to create new objects using the Class object.
     * @param args
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        String str = new String();
        System.out.println(str.getClass()); // from Object

        Class strClass = Class.forName("java.lang.String"); // from class
        System.out.println(strClass);

        String s = (String) strClass.newInstance(); // create new object

        String str1 = (String) strClass.getDeclaredConstructor().newInstance(); // create new object

        System.out.println(s);
        System.out.println(str1);
    }
}
