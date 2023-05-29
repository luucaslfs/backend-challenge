package com.luucaslfs.backendchallenge.broker;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class NotificationMessage {

    private int subscriptionId;
    private String type;
}
