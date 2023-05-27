package com.luucaslfs.backendchallenge.model;

import jakarta.validation.constraints.NotBlank;

import java.sql.Timestamp;

public record RequestUsuario (
        int id,
        Timestamp createdAt,

        @NotBlank
        String fullName
){
}
