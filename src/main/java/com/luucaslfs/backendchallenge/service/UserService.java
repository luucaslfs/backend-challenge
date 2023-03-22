package com.luucaslfs.backendchallenge.service;

import com.luucaslfs.backendchallenge.model.User;

import java.util.List;

public interface UserService {
    // create operation
    User createUser(User user);

    // read one operation
    User getUserById(int userId);

    // read all operation
    List<User> getAllUsers();

    // update operation
    User updateUser(User user, int userId);

    // delete operation
    void deleteUser(int userId);
}

