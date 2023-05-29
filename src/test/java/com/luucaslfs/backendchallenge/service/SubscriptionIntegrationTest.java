package com.luucaslfs.backendchallenge.service;

import com.luucaslfs.backendchallenge.broker.NotificationMessage;
import com.luucaslfs.backendchallenge.model.*;
import com.luucaslfs.backendchallenge.repository.StatusRepository;
import com.luucaslfs.backendchallenge.repository.SubscriptionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Timestamp;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class SubscriptionIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private UserService userService;

    @Test
    public void testSubscriptionStatusUpdate() {
        NotificationMessage notification = new NotificationMessage("SUBSCRIPTION_CANCELED", 3);

        record UserRecord(String fullName){}

        UserRecord user = new UserRecord("Test-Subscription-Status-Update");

        userService.registerUser(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<NotificationMessage> request = new HttpEntity<>(notification, headers);

        restTemplate.exchange("/update-subscription-status", HttpMethod.POST, request, Void.class);

        // Assert the expected results after the status update
        Subscription updatedSubscription = subscriptionRepository.findById(notification.getSubscriptionId()).orElse(null);
        Status expectedStatus = statusRepository.findById(3).orElse(null);
        assert updatedSubscription != null;
        Assertions.assertEquals(expectedStatus, updatedSubscription.getStatus(), "Subscription status should be updated");


        // Perform additional assertions and verifications
    }

    // Write more integration test methods to cover different scenarios
}
