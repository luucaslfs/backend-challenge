package com.luucaslfs.backendchallenge.broker;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class NotificationMessage {

    private int subscriptionId;
    private String type;

    public NotificationMessage(String type, int subscriptionId){
        this.type = type;
        this.subscriptionId = subscriptionId;
    }
}
