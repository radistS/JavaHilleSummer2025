package com.hillel.spring.jwt.security;

import com.hillel.spring.jwt.model.User;
import com.hillel.spring.jwt.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.annotation.PostConstruct;
import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    public static final short AUTH_HEADER_START_INDEX = 7;

    @Qualifier("userDetailsServiceImpl")
    private final UserDetailsService userDetailsService;

    private final UserRepository userRepository;

    @Value("${jwt.secret}")
    private String secretKeyBase64;

    @Value("${jwt.header}")
    private String authorizationHeader;

    @Value("${jwt.expiration}")
    private long validityInMilliseconds; // expiry period in seconds

    private SecretKey secretKey;

    // Инициализация ключа
    @PostConstruct
    protected void init() {
        byte[] decodedKey = Base64.getDecoder().decode(secretKeyBase64);
        if (decodedKey.length < 32) {
            throw new IllegalArgumentException("JWT secret key must be at least 256 bits (32 bytes).");
        }
        this.secretKey = Keys.hmacShaKeyFor(decodedKey);
    }

    // Метод для генерации JWT токена
    public String generateToken(String username) {
        User user = userRepository.findByEmail(username)
            .orElseThrow(() -> new UsernameNotFoundException("User doesn't exist"));

        Claims claims = Jwts.claims().setSubject(user.getEmail());
        claims.put("user_name", user.getLastName() + " " + user.getFirstName());
        claims.put("role", user.getRole());

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds * 1000);

        return Jwts.builder()
            .setSubject(username)
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(validity)
            .signWith(secretKey, SignatureAlgorithm.HS256)
            .compact();
    }

    // Метод для валидации JWT токена
    public boolean validateToken(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token);

            return claimsJws.getBody().getExpiration().after(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            System.err.println("Invalid or expired JWT token: " + e.getMessage());
            return false;
        }
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private String getUsername(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(secretKey)
            .build()
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(authorizationHeader);
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(AUTH_HEADER_START_INDEX);
        }
        return null;
    }
}
