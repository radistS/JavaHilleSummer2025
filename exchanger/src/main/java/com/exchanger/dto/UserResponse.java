package com.exchanger.dto;

import java.util.UUID;

public record UserResponse(
    UUID id,
    String firstName,
    String lastName,
    String phone,
    String email
) {

}
