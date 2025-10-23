package com.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class SpringDataM2MApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataM2MApplication.class, args);
    }

}
