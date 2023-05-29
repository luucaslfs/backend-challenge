package com.luucaslfs.backendchallenge.service;

import com.luucaslfs.backendchallenge.model.Subscription;
import com.luucaslfs.backendchallenge.repository.StatusRepository;
import com.luucaslfs.backendchallenge.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public List<Subscription> getAllSubscriptionsNeverActivated() {
        return subscriptionRepository.findAllByStatusId(1);
    }
}
