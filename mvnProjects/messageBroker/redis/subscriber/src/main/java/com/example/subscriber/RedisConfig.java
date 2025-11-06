package com.example.subscriber;

import io.lettuce.core.ClientOptions;
import io.lettuce.core.SocketOptions;
import java.time.Duration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisConfig {

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        // Настройки клиента: таймауты, автопереподключение, keepAlive
        ClientOptions clientOptions = ClientOptions.builder()
            .autoReconnect(true)
            .build();

        SocketOptions socketOptions = SocketOptions.builder()
            .keepAlive(true)
            .build();

        LettuceClientConfiguration clientCfg = LettuceClientConfiguration.builder()
            .commandTimeout(Duration.ofSeconds(5))
            .shutdownTimeout(Duration.ofMillis(0))
            .clientOptions(clientOptions)
            .build();

        LettuceConnectionFactory f = new LettuceConnectionFactory(
            new RedisStandaloneConfiguration("localhost", 6379),
            clientCfg
        );
        f.setShareNativeConnection(false);
        f.setValidateConnection(true);
        return f;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory cf) {
        return new StringRedisTemplate(cf);
    }
}
