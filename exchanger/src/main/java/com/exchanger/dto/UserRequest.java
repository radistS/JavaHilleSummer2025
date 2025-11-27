package com.exchanger.dto;

import jakarta.validation.constraints.Email;

public record UserRequest(
    String firstName,
    String lastName,
    String phone,
    @Email
    String email
) {

}
