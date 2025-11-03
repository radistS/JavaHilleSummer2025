package com.example.otp.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
public class OtpRecord implements Serializable {
    private String code;
    private int attempts;
    private Instant lastSentAt;
}
