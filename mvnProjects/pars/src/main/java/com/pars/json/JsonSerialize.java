package com.pars.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pars.User;
import com.pars.UserLittle;

public class JsonSerialize {
    public static void main(String[] args) throws JsonProcessingException {
        User user = new User().setFirstName("Alex").setLastName("Stepurko").setAge(33).setTech("React");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        System.out.println(objectMapper.writeValueAsString(user));
        UserLittle us = objectMapper.readValue(objectMapper.writeValueAsString(user), UserLittle.class);

        User clone = objectMapper.readValue(objectMapper.writeValueAsString(user), User.class);

        System.out.println(us);
        System.out.println(clone);

        System.out.printf("user == clone: %b\n", user == clone);
        System.out.printf("user.equals(clone): %b\n", user.equals(clone));

    }
}
