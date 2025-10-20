package com.spring.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfig {
    @Bean(name = "helloWorld")
    @Scope(value = "singleton")
    public SpringHelloWorld getHelloWorld() {
        return new SpringHelloWorld();
    }

    @Bean(name = "userIvanov")
    @Primary // This bean will be preferred when multiple candidates are qualified to autowire a single-valued dependency.
    public User userIvanov() {
        return new User("Ivan", "Ivanov", "ivan@ivanov.com");
    }

    @Bean(name = "sidr")
    public User userSidorov() {
        return new User("Sidr", "Sidorov", "sidr@sidorov.com");
    }

    @Bean(name = "print")
    @Scope(value = "prototype")
    public Print pr() {
        return new Print();
    }

}
