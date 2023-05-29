package com.luucaslfs.backendchallenge.service;

import com.luucaslfs.backendchallenge.model.UserDTO;
import com.luucaslfs.backendchallenge.model.Subscription;
import com.luucaslfs.backendchallenge.model.User;
import com.luucaslfs.backendchallenge.repository.StatusRepository;
import com.luucaslfs.backendchallenge.repository.SubscriptionRepository;
import com.luucaslfs.backendchallenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User registerUser(UserDTO data) {
        User user = User.builder()
                .fullName(data.fullName())
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .build();
        Subscription subscription = Subscription.builder()
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .user(user)
                .status(statusRepository.findByStatusName("NEVER_ACTIVATED").get())
                .build();
        subscriptionRepository.save(subscription);
        return user;
    }

    @Transactional
    public Optional<User> updateUser(UserDTO data) {
        Optional<User> optionalUser = userRepository.findById(data.id());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setFullName(data.fullName());
            // Set other fields if necessary
            // Perform any additional business logic or validation here
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }

}
