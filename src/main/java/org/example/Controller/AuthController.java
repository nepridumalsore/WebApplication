package org.example.Controller;

import org.example.Security.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.Service.AuthService;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        String token = authService.authenticate(request.username(), request.password());
        if (token != null) {
            return token;
        } else {
            return "Invalid credentials";
        }
    }

    @GetMapping("/protected")
    public String protectedResource(@RequestHeader("Authorization") String token) {
        if (authService.authorize(token)) {
            return "Hello, " + authService.getUsernameFromToken(token);
        } else {
            return "Invalid token";
        }
    }
}
