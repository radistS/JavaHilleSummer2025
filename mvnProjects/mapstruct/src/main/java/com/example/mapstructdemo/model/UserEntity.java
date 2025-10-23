package com.example.mapstructdemo.model;

import java.time.Instant;
import lombok.Data;

@Data
public class UserEntity {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private AddressEntity address;
    private Role role;
    private Instant createdAt;

}
