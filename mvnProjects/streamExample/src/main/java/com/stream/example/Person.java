package com.stream.example;

import lombok.Data;

@Data
public class Person {
    private String name;
    private int age;
    private String email;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
