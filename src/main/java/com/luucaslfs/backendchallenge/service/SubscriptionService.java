package com.luucaslfs.backendchallenge.service;

import com.luucaslfs.backendchallenge.model.*;
import com.luucaslfs.backendchallenge.repository.EventHistoryRepository;
import com.luucaslfs.backendchallenge.repository.StatusRepository;
import com.luucaslfs.backendchallenge.repository.SubscriptionRepository;
import com.luucaslfs.backendchallenge.repository.UserRepository;
import org.hibernate.event.internal.EvictVisitor;
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

    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    public Optional<Subscription> registerSubscription(SubscriptionDTO data) {
        Optional<User> optionalUser = userRepository.findById(data.user_id());
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
        Optional<Subscription> optionalSubscription = subscriptionRepository.findById(data.id());
        Optional<User> optionalUser = userRepository.findById(data.user_id());
        Optional<Status> optionalStatus = statusRepository.findById(data.status_id());

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
    public Optional<Subscription> updateSubscriptionStatus(SubscriptionDTO data) {
        Optional<Subscription> optionalSubscription = subscriptionRepository.findById(data.id());
        Optional<Status> optionalStatus = statusRepository.findById(data.status_id());

        if (optionalSubscription.isPresent()) {
            Subscription subscription = optionalSubscription.get();
            subscription.setStatus(optionalStatus.get());
            subscription.setUpdatedAt(data.updatedAt());

            EventHistory eventHistory = EventHistory.builder()
                    .subscription(subscription)
                    .type("STATUS_UPDATE")
                    .createdAt(new Timestamp(System.currentTimeMillis()))
                    .build();
            eventHistoryRepository.save(eventHistory);

            return Optional.of(subscription);
        } else {
            return Optional.empty();
        }
    }
}
