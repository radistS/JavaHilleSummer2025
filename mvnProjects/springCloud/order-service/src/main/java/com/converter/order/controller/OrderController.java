package com.converter.order.controller;

import com.converter.order.client.UserClient;
import com.converter.order.dto.OrderResponse;
import com.converter.order.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final UserClient userClient;

    public OrderController(UserClient userClient) {
        this.userClient = userClient;
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<?> getOrder(@PathVariable("id") Long id) {
        try {
            UserDto user = userClient.getUser(id);
            OrderResponse response = new OrderResponse(id, "Laptop", user);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body("User service unavailable");
        }
    }
}

