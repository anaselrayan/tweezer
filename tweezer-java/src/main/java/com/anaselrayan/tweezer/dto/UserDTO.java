package com.anaselrayan.tweezer.dto;

import com.anaselrayan.tweezer.model.AppUser;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String firstname;
    private String lastname;

    public UserDTO(AppUser user) {
        this.id = user.getId();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
    }
}
