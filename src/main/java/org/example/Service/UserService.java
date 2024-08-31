package org.example.Service;

import org.example.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.example.Entity.User;

import java.util.List;

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public void addUser(User user) {
        userRepository.save(user);
    }
}