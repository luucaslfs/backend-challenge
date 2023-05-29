package com.luucaslfs.backendchallenge.repository;

import com.luucaslfs.backendchallenge.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.List;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveUser() {
        User user = User.builder()
                .fullName("Lucas")
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .build();

        userRepository.save(user);
    }

    @Test
    public void printAllUser() {
        List<User> userList =
                userRepository.findAll();

        System.out.println("userList = " + userList);
    }

}