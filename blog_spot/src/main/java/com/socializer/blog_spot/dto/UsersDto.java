package com.socializer.blog_spot.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {

    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;

    private String password;

}
