package com.luucaslfs.backendchallenge.repository;

import com.luucaslfs.backendchallenge.model.Subscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {
}