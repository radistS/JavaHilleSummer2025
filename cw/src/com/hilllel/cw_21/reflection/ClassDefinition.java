package com.hilllel.cw_21.reflection;

import java.lang.reflect.InvocationTargetException;

public class ClassDefinition {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class fooRefl = Class.forName("com.hilllel.cw_21.reflection.Foo");
        System.out.println(fooRefl.getName());

        Foo fooIn = (Foo) fooRefl.newInstance(); // before java 9

        // use this
        Foo constructor = (Foo) fooRefl.getDeclaredConstructor().newInstance(); // after java 9

        Foo foo = new Foo();
        constructor.print();
        Class fooClass = foo.getClass();

        System.out.println(fooClass.getName());
    }
}

class Foo {
    void print() {
        System.out.println("Class >> Foo.java");
    }
}


/*
 1 - new
 2 - clone
 3 - deserialisation
 4 - reflection
 */
