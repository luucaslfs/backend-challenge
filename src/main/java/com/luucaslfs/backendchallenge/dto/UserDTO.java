package com.luucaslfs.backendchallenge.dto;

import com.luucaslfs.backendchallenge.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
        int id;
        String fullName;

    public UserDTO(User user) {
            this.id = user.getId();
            this.fullName = user.getFullName();
        }
}
