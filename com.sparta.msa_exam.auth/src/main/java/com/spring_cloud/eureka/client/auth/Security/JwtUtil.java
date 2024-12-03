package com.spring_cloud.eureka.client.auth.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

import static javax.crypto.Cipher.SECRET_KEY;

@Component
public class JwtUtil {


    private final String SECRET_KEY = ("${service.jwt.secret-key}"); // 반드시 환경 변수로 설정해야 합니다.
    private static final String BEARER_PREFIX = "Bearer ";
    private static final long EXPIRATION_TIME = 3600000;

    @Value("${service.jwt.secret-key}")
    private String secretKey;

    private Key key;

    @PostConstruct
    public void init() {
        byte[] decodedKey = Base64.getDecoder().decode(secretKey);
        this.key = Keys.hmacShaKeyFor(decodedKey);
    }

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

    }

    public String validateToken(String token) {
        if (token.startsWith(BEARER_PREFIX)) {
            token = token.substring(BEARER_PREFIX.length());
        }

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public Claims extractClaims(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (JwtException | IllegalArgumentException e) {
            throw new RuntimeException("Invalid JWT Token", e);
        }
    }
}
