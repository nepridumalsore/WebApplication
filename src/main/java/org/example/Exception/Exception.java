package org.example.Exception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exception {

    @GetMapping("/error")
    public String handleError() {
        return "Error page";
    }
}
