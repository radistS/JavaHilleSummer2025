package com.spring;

import java.util.Objects;

public class Test {

    private String name;
    private Long time = System.nanoTime();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void print(){
        System.out.println("class:Test, method:print()  >>>> " + time);
        System.out.println(this.hashCode());
    }

    void init(){
        System.out.println("init method...");
    }


    public Long getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", time=" + time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Test test = (Test) o;
        return Objects.equals(name, test.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
