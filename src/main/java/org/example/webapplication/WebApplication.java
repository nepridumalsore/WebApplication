package org.example.webapplication;


import org.example.Entity.User;
import org.example.Service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
    @Bean
    public void init() {
        UserService userService = new UserService();
        User user = new User();
        userService.addUser(user);
    }
/*
    @Bean
    public ErrorController errorController() {
        return new ErrorController();
    }

    @Bean
    public SecurityConfig securityConfig() {
        return new SecurityConfig();
    }

 */
}