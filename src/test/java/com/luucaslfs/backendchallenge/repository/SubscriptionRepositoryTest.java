package com.luucaslfs.backendchallenge.repository;

import com.luucaslfs.backendchallenge.model.Subscription;
import com.luucaslfs.backendchallenge.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

@SpringBootTest
class SubscriptionRepositoryTest {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Test
    public void saveAssinatura() {
        User user = User.builder()
                .fullName("Ganso")
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .build();

        Subscription subscription = Subscription.builder()
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .user(user)
                .build();

        subscriptionRepository.save(subscription);
    }

    @Test
    public void printAllAssinaturas() {
        subscriptionRepository.findAll().forEach(System.out::println);
    }

}