package com.example.otp.servise;

public interface SmsSender {
    void sendSms(String phone, String message);
}
