package com.example.otp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "otp")
public class OtpProperties {
    private long codeTtlSeconds = 300;
    private long resendWaitSeconds = 60;
    private int maxAttempts = 5;
    private long blockDurationSeconds = 600;
}
