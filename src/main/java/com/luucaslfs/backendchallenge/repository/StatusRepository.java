package com.luucaslfs.backendchallenge.repository;

import com.luucaslfs.backendchallenge.model.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusRepository extends CrudRepository<Status, Integer> {
    Optional<Status> findByStatusName(Object statusName);
}