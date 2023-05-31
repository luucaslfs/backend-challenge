package com.luucaslfs.backendchallenge.service;

import com.luucaslfs.backendchallenge.dto.UserDTO;
import com.luucaslfs.backendchallenge.model.Status;
import com.luucaslfs.backendchallenge.model.Subscription;
import com.luucaslfs.backendchallenge.model.User;
import com.luucaslfs.backendchallenge.repository.StatusRepository;
import com.luucaslfs.backendchallenge.repository.SubscriptionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    SubscriptionRepository subscriptionRepository;

    @Mock
    StatusRepository statusRepository;

    @Captor
    ArgumentCaptor<Subscription> subscriptionCaptor;

    @Test
    public void registerUsersSuccessful() {

        //arrange
        UserDTO userDTO = UserDTO.builder()
                .fullName("User")
                .build();

        User user = User.builder()
                .fullName("User")
                .build();

        Subscription subscription = Subscription.builder()
                .user(user)
                .build();

        Status status = Status.builder()
                .statusName("NEVER_ACTIVATED")
                .build();

        Mockito.when(statusRepository.findByStatusName("NEVER_ACTIVATED")).thenReturn(Optional.of(status));
        Mockito.when(subscriptionRepository.save(subscription)).thenReturn(subscription);

        //act
        userService.registerUser(userDTO);

        //assertions

        Mockito.verify(statusRepository).findByStatusName("NEVER_ACTIVATED");
        Mockito.verify(subscriptionRepository).save(subscriptionCaptor.capture());
        Subscription savedSubscription = subscriptionCaptor.getValue();
        assert(savedSubscription.getUser().getFullName().equals("User"));
    }

}