package com.luucaslfs.backendchallenge.controller;

import com.luucaslfs.backendchallenge.dto.SubscriptionDTO;
import com.luucaslfs.backendchallenge.model.Subscription;
import com.luucaslfs.backendchallenge.service.SubscriptionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Tag(
        name = "Subscription",
        description = "Endpoints to manipulate subscriptions"
)
@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

    @Autowired
    SubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<Void> registerSubscription(@RequestBody @Valid SubscriptionDTO data){
        subscriptionService.registerSubscription(data);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateSubscription(@RequestBody @Valid SubscriptionDTO data){
        Optional<Subscription> optionalSubscription = subscriptionService.updateSubscription(data);
        if (optionalSubscription.isPresent()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
