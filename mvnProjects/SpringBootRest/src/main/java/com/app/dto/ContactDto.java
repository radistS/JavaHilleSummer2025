package com.app.dto;

import jakarta.validation.constraints.Email;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@ToString
public class ContactDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String phone;
    @Email
    private String email;


}
