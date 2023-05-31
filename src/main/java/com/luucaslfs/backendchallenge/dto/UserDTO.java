package com.luucaslfs.backendchallenge.dto;

import com.luucaslfs.backendchallenge.model.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
        int id;
        String fullName;

    public UserDTO(User user) {
            this.id = user.getId();
            this.fullName = user.getFullName();
        }
}
