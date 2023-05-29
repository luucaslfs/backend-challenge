package com.luucaslfs.backendchallenge.controller;

import com.luucaslfs.backendchallenge.model.Subscription;
import com.luucaslfs.backendchallenge.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping
    public ResponseEntity<List<Subscription>> getAllSubscriptionsNeverActivated(){
        List<Subscription> subscriptionsNeverActivated = statusService.getAllSubscriptionsNeverActivated();
        return ResponseEntity.ok(subscriptionsNeverActivated);
    }
}
