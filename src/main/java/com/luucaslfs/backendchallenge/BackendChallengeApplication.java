package com.luucaslfs.backendchallenge;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
@OpenAPIDefinition
public class BackendChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendChallengeApplication.class, args);
    }
}
