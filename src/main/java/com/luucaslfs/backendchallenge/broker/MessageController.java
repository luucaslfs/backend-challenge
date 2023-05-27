package com.luucaslfs.backendchallenge.broker;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Tag(name = "Message", description = "Endpoint to send message to the RabbitMQ server")
public class MessageController {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/update-subscription-status")
    public String publishMessage(@RequestBody CustomMessage message) {
        message.setMessageId(UUID.randomUUID().toString());
        template.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, "subscription-status", message);
        return "Message published";
    }

}
