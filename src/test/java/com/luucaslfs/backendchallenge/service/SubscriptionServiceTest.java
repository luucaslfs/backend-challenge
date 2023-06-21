package com.luucaslfs.backendchallenge.service;

import com.luucaslfs.backendchallenge.dto.SubscriptionDTO;
import com.luucaslfs.backendchallenge.model.EventHistory;
import com.luucaslfs.backendchallenge.model.Status;
import com.luucaslfs.backendchallenge.model.Subscription;
import com.luucaslfs.backendchallenge.model.User;
import com.luucaslfs.backendchallenge.repository.EventHistoryRepository;
import com.luucaslfs.backendchallenge.repository.StatusRepository;
import com.luucaslfs.backendchallenge.repository.SubscriptionRepository;
import com.luucaslfs.backendchallenge.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SubscriptionServiceTest {

    @InjectMocks
    SubscriptionService subscriptionService;

    @Mock
    SubscriptionRepository subscriptionRepository;

    @Mock
    StatusRepository statusRepository;

    @Mock
    EventHistoryRepository eventHistoryRepository;

    @Mock
    UserRepository userRepository;

    @Captor
    ArgumentCaptor<Subscription> subscriptionCaptor;

    @Captor
    ArgumentCaptor<EventHistory> eventHistoryArgumentCaptor;

    @Test
    void updateSubscriptionSuccessful() {

        //arrange
        SubscriptionDTO data = SubscriptionDTO.builder()
                .id(999)
                .user_id(999)
                .status_id(1)
                .build();

        User user = User.builder()
                .id(999)
                .build();

        Status status = Status.builder()
                .id(1)
                .statusName("NEVER_ACTIVATED")
                .build();

        Subscription subscription = Subscription.builder()
                .id(999)
                .user(user)
                .status(status)
                .build();

        Mockito.when(subscriptionRepository.findById(data.getId())).thenReturn(java.util.Optional.of(subscription));
        Mockito.when(userRepository.findById(data.getUser_id())).thenReturn(java.util.Optional.of(user));
        Mockito.when(statusRepository.findById(data.getStatus_id())).thenReturn(java.util.Optional.of(subscription.getStatus()));


        //act
        subscriptionService.updateSubscription(data);

        //assertions
        Mockito.verify(subscriptionRepository).findById(data.getId());
        Mockito.verify(userRepository).findById(data.getUser_id());
        Mockito.verify(statusRepository).findById(data.getStatus_id());
        assertEquals("NEVER_ACTIVATED", subscription.getStatus().getStatusName());

        //Mockito.verify(subscription).setStatus(status);
        //Mockito.verify(subscription).setUser(user);
    }

    @Test
    void updateSubscriptionStatusSuccessful() {

        //arrange
        int subscriptionId = 999;
        int statusId = 3;

        User user = User.builder()
                .id(999)
                .build();

        Status status = Status.builder()
                .id(1)
                .statusName("NEVER_ACTIVATED")
                .build();

        Subscription subscription = Subscription.builder()
                .id(999)
                .user(user)
                .status(status)
                .build();

        EventHistory eventHistory = EventHistory.builder()
                .id(0)
                .subscription(subscription)
                .type("STATUS_UPDATE_TO_CANCELLED")
                .build();

        Status status_new = Status.builder()
                .id(3)
                .statusName("CANCELLED")
                .build();

        Mockito.when(subscriptionRepository.findById(subscriptionId)).thenReturn(java.util.Optional.of(subscription));
        Mockito.when(statusRepository.findById(statusId)).thenReturn(java.util.Optional.of(status_new));
        Mockito.when(eventHistoryRepository.save(Mockito.any(EventHistory.class))).thenReturn(eventHistory);

        //act
        subscriptionService.updateSubscriptionStatus(subscriptionId, statusId);

        //assertions
        Mockito.verify(subscriptionRepository).findById(subscriptionId);
        Mockito.verify(statusRepository).findById(statusId);
        Mockito.verify(eventHistoryRepository).save(eventHistoryArgumentCaptor.capture());
        EventHistory savedEventHistory = eventHistoryArgumentCaptor.getValue();
        assertEquals(savedEventHistory.getType(), "STATUS_UPDATE_TO_CANCELLED");
        assertEquals(status_new, subscription.getStatus());
    }
}