package com.exchanger.controller;

import com.exchanger.dto.UserRequest;
import com.exchanger.dto.UserResponse;
import com.exchanger.service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users/")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping
    public UUID createUser(@Valid @RequestBody UserRequest user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }


    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable("id") String id) {
        return userService.getUserById(Objects.requireNonNull(UUID.fromString(id)));
    }

}
