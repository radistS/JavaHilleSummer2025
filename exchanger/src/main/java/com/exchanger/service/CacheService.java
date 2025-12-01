package com.exchanger.service;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheService {
    @CachePut(value = "otpCache", key = "#key")
    public String addValueToCache(String key, String value) {
        System.out.println("Adding value to cache: " + key + " -> " + value);
        return value;
    }

    @Cacheable(value = "otpCache", key = "#key")
    public String getValueFromCache(String key) {
        return "Value not found in cache!";
    }

}
