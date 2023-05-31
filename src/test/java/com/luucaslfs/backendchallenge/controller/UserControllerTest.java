package com.luucaslfs.backendchallenge.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luucaslfs.backendchallenge.dto.SubscriptionDTO;
import com.luucaslfs.backendchallenge.dto.UserDTO;
import com.luucaslfs.backendchallenge.model.User;
import com.luucaslfs.backendchallenge.repository.SubscriptionRepository;
import com.luucaslfs.backendchallenge.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @BeforeEach
    void setup() {
        UserDTO USER_RECORD_1 = UserDTO.builder()
                .fullName("John Integrator Tester")
                .build();
    }

    @AfterEach
    void tearDown() {
        subscriptionRepository.deleteAll();
    }

    @Test
    void registerUser() throws Exception {

        UserDTO USER_RECORD_2 = UserDTO.builder()
                .fullName("Peter Integrator Tester")
                .build();

        String userDTO = mapper.writeValueAsString(USER_RECORD_2);

        mockMvc.perform(MockMvcRequestBuilders.post("/user")
                        .contentType("application/json")
                        .characterEncoding("UTF-8")
                        .content(userDTO))
                .andExpect((MockMvcResultMatchers.status().isOk()))
                .andDo(MockMvcResultHandlers.print());
    }
}