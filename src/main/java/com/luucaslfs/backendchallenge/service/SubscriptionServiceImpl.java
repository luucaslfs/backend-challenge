package com.luucaslfs.backendchallenge.service;

import com.luucaslfs.backendchallenge.exception.ResourceNotFoundException;
import com.luucaslfs.backendchallenge.model.Status;
import com.luucaslfs.backendchallenge.model.Subscription;
import com.luucaslfs.backendchallenge.model.User;
import com.luucaslfs.backendchallenge.repository.StatusRepository;
import com.luucaslfs.backendchallenge.repository.SubscriptionRepository;
import com.luucaslfs.backendchallenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StatusRepository statusRepository;

    public Subscription createSubscription(Subscription subscription) throws ResourceNotFoundException {
        User user = userRepository.findById(subscription.getUser().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User"));
        subscription.setUser(user);

        Status status = statusRepository.findById(subscription.getStatus().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Status"));
        subscription.setStatus(status);

        return subscriptionRepository.save(subscription);
    }

    public Subscription getSubscriptionById(int subscriptionId) {
        return subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new ResourceNotFoundException("Subscription"));
    }

    public List<Subscription> getAllSubscriptions() {
        return (List<Subscription>) subscriptionRepository.findAll();
    }

    @Override
    public Subscription updateSubscription(Subscription subscription, int subscriptionId) {
        return null;
    }

    public Subscription updateSubscriptionStatus(int subscriptionId, int statusId) {
        Subscription subscription = subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new ResourceNotFoundException("Subscription"));
        Status status = statusRepository.findById(statusId)
                .orElseThrow(() -> new ResourceNotFoundException("Status"));
        subscription.setStatus(status);
        subscription.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        return subscriptionRepository.save(subscription);
    }

    public boolean deleteSubscription(int subscriptionId) {
        try {
            subscriptionRepository.deleteById(subscriptionId);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
}