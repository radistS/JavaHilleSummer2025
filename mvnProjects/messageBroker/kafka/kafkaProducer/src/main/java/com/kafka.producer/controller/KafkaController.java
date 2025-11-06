package com.kafka.producer.controller;


import com.kafka.producer.User;
import com.kafka.producer.service.KafkaProducer;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
@Slf4j
public class KafkaController {

    private final KafkaProducer producer;

    @PostMapping("/producer")
    public void sendMessage(@RequestParam String message) {
        producer.sendMessage(message);
    }

    @PostMapping("/user")
    public void sendMessage(@RequestBody User message) {
        producer.sendUser(message);
    }
}
