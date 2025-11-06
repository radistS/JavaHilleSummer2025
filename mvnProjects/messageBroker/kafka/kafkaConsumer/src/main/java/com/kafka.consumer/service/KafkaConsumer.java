package com.kafka.consumer.service;

import com.kafka.producer.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

//    @KafkaListener(topics = "topic")
//    public void consumeMessage(User message) {
//        System.out.println("Received message: " + message);
//    }

    @KafkaListener(topics = "topic")
    public void consumeMessage(String message) {
        System.out.println("Received message: " + message);
    }

}
