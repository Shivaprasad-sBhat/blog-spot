package com.socializer.blog_spot.service;

import com.socializer.blog_spot.model.Users;
import com.socializer.blog_spot.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    public Users registerUser(Users user){

        return userRepo.save(user);

    }


}
