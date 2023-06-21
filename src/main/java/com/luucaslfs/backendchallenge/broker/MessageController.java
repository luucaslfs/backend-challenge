package com.luucaslfs.backendchallenge.broker;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Tag(
        name = "Subscription Status Update",
        description = "Endpoint to send a notification message to the RabbitMQ server.\n" +
                "That will be consumed by the Subscription Service to update the status of a subscription."
)
@RestController

public class MessageController {

    @Autowired
    private RabbitTemplate template;

    @PutMapping("/update-subscription-status")
    public String publishMessage(@RequestBody NotificationMessage message) {
        template.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, "subscription-status", message);
        return "Message published";
    }

}
