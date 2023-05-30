package com.luucaslfs.backendchallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDTO {

    int id;
    int user_id;
    Timestamp updatedAt;
    int status_id;

    public SubscriptionDTO(int id, int status_id) {
        this.id = id;
        this.status_id = status_id;
    }

}
