package com.luucaslfs.backendchallenge.model;

import java.sql.Timestamp;

public record SubscriptionDTO(
        int id,
        Timestamp createdAt,
        Timestamp updatedAt,
        int user_id,
        int status_id
) {
}
