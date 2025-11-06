package com.example.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
@RequiredArgsConstructor
public class PublisherController {

    private final StringRedisTemplate redis;

    @GetMapping("/{msg}")
    public String send(@PathVariable("msg") String msg) {
        // RPUSH tasks <msg>
        redis.opsForList().rightPush("tasks", msg);
        return "Message enqueued: " + msg;
    }
}
