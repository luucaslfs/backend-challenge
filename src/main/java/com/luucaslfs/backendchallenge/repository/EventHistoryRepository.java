package com.luucaslfs.backendchallenge.repository;

import com.luucaslfs.backendchallenge.model.EventHistory;
import org.springframework.data.repository.CrudRepository;

public interface EventHistoryRepository extends CrudRepository<EventHistory, Integer> {
}