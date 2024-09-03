package org.example.Security;

import io.jsonwebtoken.*;

import java.util.Date;

public class JwtTokenUtil {
    private final String secret;
    private final Long expiration;

    public JwtTokenUtil(String secret, Long expiration) {
        this.secret = secret;
        this.expiration = expiration;
    }

    public String generateToken(String username) {
        Date expirationDate = new Date(System.currentTimeMillis() + expiration);
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parse(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        Jws<Claims> jws = Jwts.parser().setSigningKey(secret).parse(token);
        Claims claims = jws.getBody();
        return claims.getSubject();
    }

}
