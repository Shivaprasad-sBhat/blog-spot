package com.socializer.blog_spot.controller;

import com.socializer.blog_spot.model.Users;
import com.socializer.blog_spot.repository.UserRepo;
import com.socializer.blog_spot.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/users")
    private ResponseEntity<Users> registerUser(@RequestBody Users users){

        users.setPassword(passwordEncoder.encode(users.getPassword()));
        Users newUsers = userService.registerUser(users);

        return new ResponseEntity<>(newUsers, HttpStatus.CREATED);

    }

    @GetMapping("/getUsers")
    public Users viewProfile(Authentication authentication){

        return userRepo.findByEmail(authentication.getName()).orElseThrow(()->new BadCredentialsException("not found"));
    }

}
