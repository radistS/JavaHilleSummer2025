package com.example.otp.servise;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MockSmsSender implements SmsSender {
    @Override
    public void sendSms(String phone, String message) {
        log.info("SMS send to {}: {}", phone, message);
    }
}
