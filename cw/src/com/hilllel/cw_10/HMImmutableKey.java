package com.hilllel.cw_10;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HMImmutableKey {

    public static void main(String[] args) {

        Map<Customer, String> map = new HashMap<>();

        Customer c1 = new Customer("Oleksandr", 33);

        map.put(c1, c1.toString());

        System.out.println(map.get(c1)); // hashcode1

        c1.age = 40;

        System.out.println(map.get(c1)); // hashcode2

    }
}

class Customer {
    public  String name;
    public int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
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
        Customer customer = (Customer) o;
        return age == customer.age && Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
