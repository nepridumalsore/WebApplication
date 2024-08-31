package org.example.Controller;

import org.example.Service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.example.Model.Model;
import java.util.List;
import org.example.Entity.User;
import org.springframework.web.bind.annotation.RestController;


@RestController


public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String GetUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
}
