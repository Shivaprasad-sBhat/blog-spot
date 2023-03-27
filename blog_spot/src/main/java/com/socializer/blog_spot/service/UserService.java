package com.socializer.blog_spot.service;

import com.socializer.blog_spot.dto.UsersDto;
import com.socializer.blog_spot.model.Users;

public interface UserService {

    public UsersDto registerUser(UsersDto usersDto);
    public UsersDto updateUserDetails(UsersDto usersDto);
    public String updateUserPassword(String password);
}
