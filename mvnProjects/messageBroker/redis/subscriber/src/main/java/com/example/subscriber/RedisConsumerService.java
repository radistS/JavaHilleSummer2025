package com.example.subscriber;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class RedisConsumerService {

    private static final Logger log = LoggerFactory.getLogger(RedisConsumerService.class);
    private final StringRedisTemplate redis;

    @PostConstruct
    public void listenQueue() {
        Thread t = new Thread(this::consumeLoop, "redis-blpop-consumer");
        t.start();
    }

    private void consumeLoop() {
        while (true) {
            try {
                String msg = redis.opsForList().leftPop("tasks", Duration.ofSeconds(30)); // BLPOP 30
                if (msg != null) {
                    log.info("Received: {}", msg);
                }
            } catch (Exception e) {
                sleep(1000);
            }
        }
    }

    private static void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }
}
