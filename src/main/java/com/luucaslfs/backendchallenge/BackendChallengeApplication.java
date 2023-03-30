package com.luucaslfs.backendchallenge;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class BackendChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendChallengeApplication.class, args);
    }

}
