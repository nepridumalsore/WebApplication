package org.example.webapplication;

import org.example.Exception.Exception;
import org.example.Security.JwtConfig;
import org.example.Service.UserService;
import org.junit.runner.JUnitCore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import javax.xml.transform.Result;

@SpringBootApplication
public class WebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
        Result result = JUnitCore.runClasses(UserServiceTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println("Test failed: " + failure.toString());
        }
        System.out.println("Test result: " + result.wasSuccessful());
    }
    @Bean
    public JwtConfig getJwtConfig() {
        return new JwtConfig();
    }

    @Bean
    public UserService userService() {
        return new UserService();
    }

    @Bean
    public JwtConfig jwtConfig() {
        return new JwtConfig();
    }

    @Bean
    public Exception exception() {
        return new Exception();
    }

}