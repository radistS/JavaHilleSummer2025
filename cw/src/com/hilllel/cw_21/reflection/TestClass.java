package com.hilllel.cw_21.reflection;

public class TestClass {

    public static void main(String[] args)
        throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class fooRefl = Class.forName("com.hillel.lesson_21.reflection.Test");
        System.out.println(fooRefl.getName());

        Test ex = (Test) fooRefl.newInstance();

        System.out.println(ex);
    }

}
