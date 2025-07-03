package com.hilllel.cw_04.animal;

import java.util.Objects;

public class Cat extends Animal {
    private String name;
    private String age;

    public Cat(String name) {
        this.name = name;
    }

    public Cat() {
    }

    public Cat(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void voice() {
        System.out.println("May may...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(name, cat.name) &&
                Objects.equals(age, cat.age);
    }

}
