package com.hillel.tests.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@ToString
public class User {

    private String name;
    private String email;
    private Integer age;
    private String phone;
}
