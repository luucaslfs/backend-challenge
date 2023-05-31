package com.luucaslfs.backendchallenge.repository;

import com.luucaslfs.backendchallenge.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
    List<Subscription> findAllByStatusId(int status_id);
    Subscription findByUserId(int user_id);
}