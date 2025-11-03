package com.example.otp.servise;

import com.example.otp.config.OtpProperties;
import com.example.otp.dto.OtpRecord;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class OtpService {

    private final RedisTemplate<String, Object> redis;
    private final OtpProperties props;
    private final SmsSender smsSender;

    private static final String OTP_KEY_PREFIX = "otp:";
    private static final String LOCK_KEY_PREFIX = "otp:lock:";

    public String generateAndSend(String phone) {
        String otpKey = OTP_KEY_PREFIX + phone;
        String lockKey = LOCK_KEY_PREFIX + phone;

        Boolean blocked = redis.hasKey(lockKey);
        if (Boolean.TRUE.equals(blocked)) {
            throw new IllegalStateException("Too many attempts — temporarily blocked");
        }

        OtpRecord existing = (OtpRecord) redis.opsForValue().get(otpKey);
        Instant now = Instant.now();

        if (existing != null && existing.getLastSentAt() != null) {
            long secondsSinceLast = Duration.between(existing.getLastSentAt(), now).getSeconds();
            if (secondsSinceLast < props.getResendWaitSeconds()) {
                throw new IllegalStateException("Wait before requesting a new code");
            }
        }

        String code = generateCode();
        OtpRecord record = new OtpRecord();
        record.setCode(code);
        record.setAttempts(0);
        record.setLastSentAt(now);

        redis.opsForValue().set(otpKey, record, Duration.ofSeconds(props.getCodeTtlSeconds()));

        smsSender.sendSms(phone, "Your OTP code: " + code);

        return code;
    }

    public boolean verify(String phone, String code) {
        String otpKey = OTP_KEY_PREFIX + phone;
        String lockKey = LOCK_KEY_PREFIX + phone;

        Boolean blocked = redis.hasKey(lockKey);
        if (Boolean.TRUE.equals(blocked)) {
            return false;
        }

        Map<String, Object> map = (Map<String, Object>) redis.opsForValue().get(otpKey);

        OtpRecord record = new OtpRecord();
        record.setCode(map.get("code").toString());
        record.setAttempts(map.get("attempts") != null ? (Integer) map.get("attempts") : 0);
        record.setLastSentAt(Instant.ofEpochMilli(((Double) map.get("lastSentAt")).longValue()));

        if (record == null) return false;

        if (record.getCode().equals(code)) {
            redis.delete(otpKey);
            return true;
        } else {
            record.setAttempts(record.getAttempts() + 1);
            Long ttl = redis.getExpire(otpKey, TimeUnit.SECONDS);
            if (ttl == null || ttl <= 0) {
                ttl = props.getCodeTtlSeconds();
            }
            redis.opsForValue().set(otpKey, record, Duration.ofSeconds(ttl));

            if (record.getAttempts() >= props.getMaxAttempts()) {
                redis.opsForValue().setIfAbsent(lockKey, "1", Duration.ofSeconds(props.getBlockDurationSeconds()));
                redis.delete(otpKey);
            }
            return false;
        }
    }

    private String generateCode() {
        int v = (int) (Math.random() * 900_000) + 100_000;
        return Integer.toString(v);
    }
}
