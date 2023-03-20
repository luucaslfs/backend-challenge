package com.luucaslfs.backendchallenge.repository;

import com.luucaslfs.backendchallenge.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}