package com.luucaslfs.backendchallenge.repository;

import com.luucaslfs.backendchallenge.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {}
