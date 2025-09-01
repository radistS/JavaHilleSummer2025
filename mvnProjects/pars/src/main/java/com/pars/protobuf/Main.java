package com.pars.protobuf;

import com.pars.protobuf.PersonProto.Person;


public class Main {

    public static void main(String[] args) throws Exception {
        // Create a Person object
        Person person = Person.newBuilder()
            .setId(1)
            .setName("Olexandr")
            .setEmail("olexandr@example.com")
            .build();

        // Serialize to byte array
        byte[] bytes = person.toByteArray();

        System.out.printf("Serialized data: %s%n", java.util.Arrays.toString(bytes));

        // Deserialize from byte array
        Person deserialized = Person.parseFrom(bytes);

        System.out.println("ID: " + deserialized.getId());
        System.out.println("Name: " + deserialized.getName());
        System.out.println("Email: " + deserialized.getEmail());
    }
}
