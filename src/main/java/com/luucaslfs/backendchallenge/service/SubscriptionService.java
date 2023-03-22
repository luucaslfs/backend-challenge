package com.luucaslfs.backendchallenge.service;
import com.luucaslfs.backendchallenge.model.Subscription;

import java.util.List;

public interface SubscriptionService {
    // create operation
    Subscription createSubscription(Subscription subscription);

    // real one operation
    Subscription getSubscriptionById(int subscriptionId);
    // read all operation
    List<Subscription> getAllSubscriptions();

    // update operation
    Subscription updateSubscription(Subscription subscription, int subscriptionId);

    // delete operation
    boolean deleteSubscription(int subscriptionId);
}
