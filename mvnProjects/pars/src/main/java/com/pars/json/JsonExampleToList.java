package com.pars.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.pars.ReadFromFile;
import com.pars.User;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.SneakyThrows;

public class JsonExampleToList {

    @SneakyThrows
    public static void main(String[] args) {
       String json = ReadFromFile.readToString("/Users/oleksandrstepurko/IdeaProjects/HillelSummer2024_upd/mvnProjects/pars/src/main/resources/phoneBook.json");

        Gson gson = new Gson();
        User[] user = gson.fromJson(json, User[].class);

        List<User> users = Arrays.stream(user)
                .sorted(Comparator.comparing(User::getAge).thenComparing(User::getLastName).reversed())
                .collect(Collectors.toList());

        for (User u : user) {
            System.out.println(u);
        }

        System.out.println("---------");
        users.forEach(System.out::println);
        System.out.println("--------------");
        ObjectMapper om = new ObjectMapper();
        List<User> list =  om.readValue(json, new TypeReference<List>() {}); // to list of users

        System.out.println(list);
    }
}
