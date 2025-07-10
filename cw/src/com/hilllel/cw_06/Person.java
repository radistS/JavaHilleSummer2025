package com.hilllel.cw_06;

public class Person {

    private String userName;

    Person(String userName) {
        this.userName = userName;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object PERSON: <<" + userName + ">>  --> remove from memory");
    }

    @Override
    public String toString() {
        return this.userName;
    }
}
