package com.luucaslfs.backendchallenge.service;

import com.luucaslfs.backendchallenge.exception.ResourceNotFoundException;
import com.luucaslfs.backendchallenge.model.EventHistory;
import com.luucaslfs.backendchallenge.model.Status;
import com.luucaslfs.backendchallenge.model.Subscription;
import com.luucaslfs.backendchallenge.model.User;
import com.luucaslfs.backendchallenge.repository.EventHistoryRepository;
import com.luucaslfs.backendchallenge.repository.StatusRepository;
import com.luucaslfs.backendchallenge.repository.SubscriptionRepository;
import com.luucaslfs.backendchallenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private EventHistoryRepository eventHistoryRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public User createUser(User user) {
        // Create a new subscription with default settings
        Subscription subscription = new Subscription();
        subscription.setUser(user);
        Status status = statusRepository.findByStatusName("NEVER_ACTIVATED").orElseThrow(
                () -> new ResourceNotFoundException("Status 'NEVER_ACTIVATED' not found"));
        subscription.setStatus(status);
        subscription.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        subscription.setUpdatedAt(subscription.getCreatedAt());
        subscriptionRepository.save(subscription);

        // Set the subscription object to the user object and save it
        user.setSubscription(subscription);
        user.setCreatedAt(subscription.getCreatedAt());
        return userRepository.save(user);
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User: " + userId));
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User updateUser(User user, int userId) {
        User existingUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
        existingUser.setFullName(user.getFullName());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

    public Subscription updateSubscriptionStatus(int userId, String statusName) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
        int subscriptionId = user.getSubscription().getId();
        Subscription subscription = subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new ResourceNotFoundException("Subscription not found with id " + subscriptionId));
        Status status = statusRepository.findByStatusName(statusName)
                .orElseThrow(() -> new ResourceNotFoundException("Status not found with name " + statusName));

        subscription.setStatus(status);
        subscription.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        return subscriptionRepository.save(subscription);
    }
}