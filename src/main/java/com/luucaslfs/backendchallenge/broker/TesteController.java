package com.luucaslfs.backendchallenge.broker;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/teste")
public class TesteController {

    public TesteController(AmqpTemplate queueSender) {
        this.queueSender = queueSender;
    }

    private final AmqpTemplate queueSender;

    @GetMapping
    public String send(){

        String message = "test message";

        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("ultima", "sim");
        Message msg = new Message(message.getBytes(), messageProperties);

        queueSender.convertAndSend("streaming-exchange", "subscription-status", msg);
        return "ok. message sent";
    }

}