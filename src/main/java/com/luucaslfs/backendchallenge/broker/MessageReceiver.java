package com.luucaslfs.backendchallenge.broker;

import com.luucaslfs.backendchallenge.model.Subscription;
import com.luucaslfs.backendchallenge.dto.SubscriptionDTO;
import com.luucaslfs.backendchallenge.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.sql.Timestamp;
import java.util.Optional;

@Component
public class MessageReceiver {

    @Autowired
    private SubscriptionService subscriptionService;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void listener(NotificationMessage message) {
        int subscriptionId = message.getSubscriptionId();
        int statusId = 0;

        switch (message.getType()) {
            case "SUBSCRIPTION_PURCHASED":
                statusId = 2;
                break;
            case "SUBSCRIPTION_CANCELED":
                statusId = 3;
                break;
            case "SUBSCRIPTION_RESTARTED":
                statusId = 4;
                break;
            default:
                break;
        }

        Subscription updatedSubscription = subscriptionService.updateSubscriptionStatus(subscriptionId, statusId);
        System.out.println("Subscription updated: " + subscriptionId + " " + statusId);
    }


}
