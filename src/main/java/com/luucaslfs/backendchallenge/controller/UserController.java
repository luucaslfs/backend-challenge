package com.luucaslfs.backendchallenge.controller;

import com.luucaslfs.backendchallenge.model.User;
import com.luucaslfs.backendchallenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired private UserService userService;

    // Save operation
    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // Find one operation
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") int userId) {
        return userService.getUserById(userId);
    }

    // List all operation
    @GetMapping("/users")
    public List<User> userList() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") int userId){
        userService.deleteUser(userId);
        return "User deleted";
    }

}
