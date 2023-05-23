package com.luucaslfs.backendchallenge.service;

import com.luucaslfs.backendchallenge.model.Status;
import com.luucaslfs.backendchallenge.model.Subscription;
import com.luucaslfs.backendchallenge.model.User;
import com.luucaslfs.backendchallenge.repository.StatusRepository;
import com.luucaslfs.backendchallenge.repository.SubscriptionRepository;
import com.luucaslfs.backendchallenge.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class StatusCommandLineRunner implements CommandLineRunner {

    private final StatusRepository statusRepository;
    private final UserRepository userRepository;
    private final SubscriptionRepository subscriptionRepository;

    public StatusCommandLineRunner(StatusRepository statusRepository, UserRepository userRepository, SubscriptionRepository subscriptionRepository) {
        this.statusRepository = statusRepository;
        this.userRepository = userRepository;
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        createDefaultStatuses();
        testUserSubscription();
    }

    private void createDefaultStatuses() {
        List<String> statusNames = Arrays.asList("NEVER_ACTIVATED", "PURCHASED", "CANCELLED", "RESTARTED");
        statusNames.forEach(statusName -> {
            Optional<Status> optionalStatus = statusRepository.findByStatusName(statusName);
            if (optionalStatus.isEmpty()) {
                Status status = new Status();
                status.setStatusName(statusName);
                statusRepository.save(status);
            }
        });
    }

    private void testUserSubscription() {
        User user = new User();
        user.setFullName("Lucas Florencio");
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        userRepository.save(user);

        Subscription subscription = new Subscription();
        subscription.setUser(user);
        subscription.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        subscriptionRepository.save(subscription);
    }
}
