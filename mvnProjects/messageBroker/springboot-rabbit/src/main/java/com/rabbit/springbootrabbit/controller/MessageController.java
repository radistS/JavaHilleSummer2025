package com.rabbit.springbootrabbit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rabbit.springbootrabbit.publisher.RabbitProducer;

@RestController
@RequestMapping("/api/v1")
public class MessageController {
    @Autowired
    private RabbitProducer rabbitProducer;


    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        rabbitProducer.sendMessage(message);
        return ResponseEntity.ok("message sent to rabbitmq");
    }
}
