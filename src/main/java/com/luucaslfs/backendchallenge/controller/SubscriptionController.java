package com.luucaslfs.backendchallenge.controller;

import com.luucaslfs.backendchallenge.model.SubscriptionDTO;
import com.luucaslfs.backendchallenge.model.Subscription;
import com.luucaslfs.backendchallenge.service.SubscriptionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

    @Autowired
    SubscriptionService subscriptionService;

    @GetMapping
    public ResponseEntity<List<Subscription>> getAllSubscriptions(){
        List<Subscription> allSubscriptions = subscriptionService.getAllSubscriptions();
        return ResponseEntity.ok(allSubscriptions);
    }

    @PostMapping
    public ResponseEntity<Void> registerSubscription(@RequestBody @Valid SubscriptionDTO data){
        Optional<Subscription> newSubscription = subscriptionService.registerSubscription(data);
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

    @PutMapping("/status-purchased")
    public ResponseEntity<Void> updateSubscriptionStatus(@RequestBody @Valid SubscriptionDTO data){
        Optional<Subscription> optionalSubscription = subscriptionService.updateSubscriptionStatus(data);
        if (optionalSubscription.isPresent()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
