package com.luucaslfs.backendchallenge.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.luucaslfs.backendchallenge.dto.SubscriptionDTO;
import com.luucaslfs.backendchallenge.repository.SubscriptionRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
class SubscriptionControllerTest {

    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private SubscriptionRepository subscriptionRepository;

    @InjectMocks
    private SubscriptionController subscriptionController;

    SubscriptionDTO RECORD_1 = SubscriptionDTO.builder()
            .id(1)
            .build();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(subscriptionController).build();
    }

    @Test
    void getAllSubscriptions() {
    }

    @Test
    void registerSubscription() {
    }

    @Test
    void updateSubscription() {
    }

    @Test
    void updateSubscriptionStatus() {
    }
}