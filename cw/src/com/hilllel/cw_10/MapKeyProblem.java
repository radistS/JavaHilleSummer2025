package com.hilllel.cw_10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MapKeyProblem {

    public static void main(String[] args) {

        Map<Student, List<String>> map = new HashMap<>();

        Student s1 = new Student("John", 23);
        System.out.println("hash s1: " + s1.hashCode());

        map.put(s1, List.of("java"));

        System.out.println(map.get(s1));

        s1.setAge(24);

        System.out.println(map.get(s1));
        System.out.println("hash s1: " + s1.hashCode());
    }

}


class Student {

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
