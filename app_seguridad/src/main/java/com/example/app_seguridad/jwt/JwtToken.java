package com.example.app_seguridad.jwt;

import java.security.Key;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.app_seguridad.dto.AutorRequest;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtToken {
        public static final long JWT_TOKEN_VALIDITY = 24 * 60 * 60;
     
     @Value("${jwt.secret}")
     private String secret ;
     
     public String generateToken(AutorRequest authRequest) {
 
            Key hmacKey = new SecretKeySpec(secret.getBytes(), SignatureAlgorithm.HS256.getJcaName());
            Instant now = Instant.now();
            String jwtToken = Jwts.builder()
                    .claim("usuario", authRequest.getNombre())
                //     .claim("pass", authRequest.getPassword())
                    .setSubject(authRequest.getNombre())
                    .setId(UUID.randomUUID().toString())
                    .setIssuedAt(Date.from(now))
                    .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                    .signWith(hmacKey)
                    .compact();
           
            return jwtToken;
}
}
