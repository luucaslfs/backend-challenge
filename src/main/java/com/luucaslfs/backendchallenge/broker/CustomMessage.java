package com.luucaslfs.backendchallenge.broker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Date;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomMessage {

    private String messageId;
    private String message;
    private Date messageDate;
}
