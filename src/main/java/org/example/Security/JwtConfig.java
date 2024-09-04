package org.example.Security;

import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JwtConfig {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    @Bean
    public JwtTokenUtil jwtTokenUtil() {
        return new JwtTokenUtil(secret, expiration);
    }
}
