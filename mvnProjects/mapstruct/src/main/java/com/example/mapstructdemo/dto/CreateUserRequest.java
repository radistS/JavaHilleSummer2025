package com.example.mapstructdemo.dto;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private AddressDto address;
    private String role;
}
