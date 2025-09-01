package com.pars.xml.jacson;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.pars.User;

import com.pars.UserOne;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class UserJaksonExample {
    public static void main(String[] args) throws IOException {
        File file = new File(Objects.requireNonNull(UserJaksonExample.class.getClassLoader().getResource("phoneBookOne.xml")).getFile());
//        File file = new File(Objects.requireNonNull(UserJaksonExample.class.getClassLoader().getResource("phoneBook_1.xml")).getFile());
        XmlMapper xmlMapper = new XmlMapper();
//        User[] value = xmlMapper.readValue(file, User[].class);
        UserOne value = xmlMapper.readValue(file, UserOne.class);
        System.out.println(value);

//        Arrays.stream(value).forEach(System.out::println);
    }
}
