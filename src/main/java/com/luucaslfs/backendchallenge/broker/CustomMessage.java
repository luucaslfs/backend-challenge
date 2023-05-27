package com.luucaslfs.backendchallenge.broker;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomMessage {

    private String messageId;
    private String message;
    private Date messageDate;
}
