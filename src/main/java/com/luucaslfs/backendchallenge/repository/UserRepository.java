package com.luucaslfs.backendchallenge.repository;

import com.luucaslfs.backendchallenge.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByFullName(Object fullName);
}
