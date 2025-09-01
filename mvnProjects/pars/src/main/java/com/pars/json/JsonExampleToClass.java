package com.pars.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.pars.User;

import java.io.IOException;

public class JsonExampleToClass {

    public static void main(String[] args) throws IOException {
        String json = "{" +
                "        'firstName': 'Alex'," +
                "        'lastName': 'Stepurko'," +
                "        'age': '40'," +
                "        'workAge': '7'," +
                "        'email': 'stepurko@info.com'," +
                "        'technology': 'Java'," +
                "        'technology_fe': 'React'" +
                "      }";
//         Gson lib example
        Gson gson = new Gson();
        User user = gson.fromJson(json, User.class); // json to class
        System.out.println(user.toString());
        user.setTechnology("React");
        System.out.println(gson.toJson(user)); // class to json

        User user1 = gson.fromJson(gson.toJson(user), User.class);

        System.out.println(user.hashCode());
        System.out.println(user1.hashCode());

//        // jackson lib example

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);

        User us = objectMapper.readValue(json, User.class);
        us.setAge(22);
        System.out.println(us.toString());

        System.out.println(objectMapper
            .writerWithDefaultPrettyPrinter()
            .writeValueAsString(us));
        System.out.println(objectMapper.writeValueAsString(us));
    }
}
