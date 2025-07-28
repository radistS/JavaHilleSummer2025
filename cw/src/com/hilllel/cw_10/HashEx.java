package com.hilllel.cw_10;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashEx {
    public static void main(String[] args) throws InterruptedException {

        // create 1 obj
        User user1 = new User("Alex", "23");
        Thread.sleep(1_000);
        // create 2 obj
        User user2 = new User("Alex", "23");
        // create 3 obj
        User user3 = new User("Alex", "3");



        // create collection set
        Set<User> users = new HashSet<>();

        // sout u1 and u2
        System.out.println(user1);
        System.out.println(user1.hashCode());
        System.out.println(user2);
        System.out.println(user2.hashCode());
        System.out.println(user3);
        System.out.println(user3.hashCode());

        // add u1 to u2 to collection
        users.add(user1); // true
        users.add(user2); // false
        users.add(user3); // true

        System.out.println(users);
    }
}

class User{
    String name;
    String age;
    Long timeStamp;

    public User(String name, String age) {
        this.name = name;
        this.age = age;
        this.timeStamp = System.currentTimeMillis();
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}


