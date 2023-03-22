package com.luucaslfs.backendchallenge.repository;

import com.luucaslfs.backendchallenge.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}