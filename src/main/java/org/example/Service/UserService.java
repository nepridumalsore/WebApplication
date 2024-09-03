package org.example.Service;

import com.sun.jdi.request.DuplicateRequestException;
import jakarta.validation.ValidationException;
import org.example.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.example.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public static List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User addUser(User user) {
        if (userRepository.existsByUsername(user.getName())) {
            throw new DuplicateRequestException("User with name " + user.getName() + " already exists");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new DuplicateRequestException("User with email " + user.getEmail() + " already exists");
        }
        else {userRepository.save(user);}
    }
    public User GetUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
    public static User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
    public User updateUser(User user) {
        userRepository.save(user);
        return user;
    }


    private void validateUser(User user) {
        if (user == null) {
            throw new ValidationException("Data cannot be null");
        }
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new ValidationException("Name cannot be empty");
        }
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new ValidationException("Email cannot be empty");
        }
        if (!user.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new ValidationException("Email is not valid");
        }
    }

    public User findUserById(long id) {
        return userRepository.findById(id).orElseThrow();
    }
}