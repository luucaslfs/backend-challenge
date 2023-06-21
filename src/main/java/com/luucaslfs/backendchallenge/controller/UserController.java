package com.luucaslfs.backendchallenge.controller;

import com.luucaslfs.backendchallenge.dto.UserDTO;
import com.luucaslfs.backendchallenge.model.User;
import com.luucaslfs.backendchallenge.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(
        name = "User",
        description = "Endpoints to manipulate users"
)
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }

    @PostMapping
    public ResponseEntity<Void> registerUser(@RequestBody @Valid UserDTO data){
        User newUser = userService.registerUser(data);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateUser(@RequestBody @Valid UserDTO data){
        Optional<User> optionalUser = userService.updateUser(data);
        if (optionalUser.isPresent()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
