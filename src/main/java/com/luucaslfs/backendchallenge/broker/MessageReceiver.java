package com.luucaslfs.backendchallenge.broker;

import org.springframework.stereotype.Component;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void listener(CustomMessage message) {
        System.out.println(message);
    }

}
