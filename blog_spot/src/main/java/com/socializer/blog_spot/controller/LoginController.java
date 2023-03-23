package com.socializer.blog_spot.controller;

import com.socializer.blog_spot.model.Users;
import com.socializer.blog_spot.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserRepo userRepo;


    @GetMapping("/signIn")
    public ResponseEntity<Users> signIn(Authentication authentication){

      Users users =  userRepo.findByEmail(authentication.getName()).orElseThrow(() ->new BadCredentialsException("Bad credentials."));

      return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
    }
}
