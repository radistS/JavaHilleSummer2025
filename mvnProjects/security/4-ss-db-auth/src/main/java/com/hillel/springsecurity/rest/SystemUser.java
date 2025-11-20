package com.hillel.springsecurity.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SystemUser {
    private String email;
    private String phone;
    private String password;
}
