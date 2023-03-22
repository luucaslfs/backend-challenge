package com.luucaslfs.backendchallenge.controller;

import com.luucaslfs.backendchallenge.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscriptionController {

    @Autowired private SubscriptionService subscriptionService;


}
