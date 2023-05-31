package com.luucaslfs.backendchallenge.service;

import com.luucaslfs.backendchallenge.dto.SubscriptionDTO;
import com.luucaslfs.backendchallenge.exception.ResourceNotFoundException;
import com.luucaslfs.backendchallenge.model.*;
import com.luucaslfs.backendchallenge.repository.EventHistoryRepository;
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
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private EventHistoryRepository eventHistoryRepository;

    public Optional<Subscription> registerSubscription(SubscriptionDTO data) {
        Optional<User> optionalUser = userRepository.findById(data.getUser_id());
        Optional<Status> optionalStatus = statusRepository.findByStatusName("NEVER_ACTIVATED");

        if (optionalUser.isPresent()) {
            Subscription newSubscription = Subscription.builder()
                    .user(optionalUser.get())
                    .createdAt(new Timestamp(System.currentTimeMillis()))
                    .status(optionalStatus.get())
                    .build();
            // Set other fields if necessary
            // Perform any additional business logic or validation here
            subscriptionRepository.save(newSubscription);
            return Optional.of(newSubscription);
        } else {
            return Optional.empty();
        }
    }

    @Transactional
    public Optional<Subscription> updateSubscription(SubscriptionDTO data) {
        Optional<Subscription> optionalSubscription = subscriptionRepository.findById(data.getId());
        Optional<User> optionalUser = userRepository.findById(data.getUser_id());
        Optional<Status> optionalStatus = statusRepository.findById(data.getStatus_id());

        if (optionalSubscription.isPresent()) {
            Subscription subscription = optionalSubscription.get();
            subscription.setStatus(optionalStatus.get());
            subscription.setUser(optionalUser.get());
            // Set other fields if necessary
            // Perform any additional business logic or validation here
            return Optional.of(subscription);
        } else {
            return Optional.empty();
        }
    }

    @Transactional
    public Subscription updateSubscriptionStatus(int subscriptionId, int statusId) {
        Optional<Subscription> optionalSubscription = subscriptionRepository.findById(subscriptionId);
        Optional<Status> optionalStatus = statusRepository.findById(statusId);

        if (optionalSubscription.isEmpty()) {
            throw new ResourceNotFoundException("Subscription not found with id " + subscriptionId);
        }

        Subscription subscription = optionalSubscription.get();
        subscription.setStatus(optionalStatus.get());
        subscription.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        EventHistory eventHistory = EventHistory.builder()
                .subscription(subscription)
                .type("STATUS_UPDATE_TO_" + optionalStatus.get().getStatusName())
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .build();
        eventHistoryRepository.save(eventHistory);

        return subscription;
    }
}
