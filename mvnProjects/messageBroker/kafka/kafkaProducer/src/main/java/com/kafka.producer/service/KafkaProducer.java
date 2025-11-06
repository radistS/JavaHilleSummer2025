package com.kafka.producer.service;

import lombok.RequiredArgsConstructor;
import com.kafka.producer.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTemplate<String, User> userTemplate;
    private final String TOPIC_NAME= "topic";

    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC_NAME, message);
        System.out.println("Message : " + message +
            " has been sucessfully sent to the topic: " + TOPIC_NAME);
    }

    public void sendUser(User message) {
        userTemplate.send(TOPIC_NAME, message);
        System.out.println("Message send");
    }

}
