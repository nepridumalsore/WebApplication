package org.example.Service;

import org.example.Security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private JwtTokenUtil jwtTokenUtil;

    public AuthService(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Autowired
    public String authenticate(String username, String password) {
        if (username.equals("admin") && password.equals("admin")) {
            return jwtTokenUtil.generateToken(username);
        } else {
            return null;
        }
    }

    public boolean authorize(String token) {
        return jwtTokenUtil.validateToken(token);
    }

    public String getUsernameFromToken(String token) {
        return jwtTokenUtil.getUsernameFromToken(token);
    }
}
