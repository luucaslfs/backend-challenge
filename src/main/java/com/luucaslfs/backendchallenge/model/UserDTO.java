package com.luucaslfs.backendchallenge.model;

import jakarta.validation.constraints.NotBlank;

import java.sql.Timestamp;

public record UserDTO(
        int id,
        Timestamp createdAt,

        @NotBlank
        String fullName
){
}
