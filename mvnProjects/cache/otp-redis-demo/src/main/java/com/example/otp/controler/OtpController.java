package com.example.otp.controler;

import com.example.otp.dto.OtpRecord;
import com.example.otp.servise.OtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/otp")
@RequiredArgsConstructor
public class OtpController {

    private final OtpService otpService;

    @PostMapping("/generate")
    public ResponseEntity<?> generate(@RequestParam String phone) {
        try {
            String code = otpService.generateAndSend(phone);
            return ResponseEntity.ok("OTP sent (demo code: " + code + ")");
        } catch (IllegalStateException e) {
            return ResponseEntity.status(429).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("error");
        }
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verify(@RequestParam String phone, @RequestParam String code) {
        boolean ok = otpService.verify(phone, code);
        return ok ? ResponseEntity.ok("verified") : ResponseEntity.badRequest().body("invalid or blocked");
    }

}
