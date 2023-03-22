package com.luucaslfs.backendchallenge.service;

import com.luucaslfs.backendchallenge.exception.ResourceNotFoundException;
import com.luucaslfs.backendchallenge.model.Status;
import com.luucaslfs.backendchallenge.model.Subscription;
import com.luucaslfs.backendchallenge.model.User;
import com.luucaslfs.backendchallenge.repository.SubscriptionRepository;
import com.luucaslfs.backendchallenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Override
    public User createUser(User user) {
        Subscription subscription = new Subscription();
        subscription.setUser(user);
        subscription.setStatus(new Status()); // set default status here if needed
        subscription.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        subscription.setUpdatedAt(subscription.getCreatedAt());
        subscriptionRepository.save(subscription);
        user.setCreatedAt(subscription.getCreatedAt());
        return userRepository.save(user);
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User"));
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User updateUser(User user, int userId) {
        User existingUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User"));
        user.setId(existingUser.getId());
        user.setCreatedAt(existingUser.getCreatedAt());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }
}