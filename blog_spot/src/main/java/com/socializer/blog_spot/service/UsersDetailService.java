package com.socializer.blog_spot.service;

import com.socializer.blog_spot.model.Users;
import com.socializer.blog_spot.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

      Optional<Users> users =  userRepo.findByEmail(username);

      if(users.isPresent()){

       Users  user =users.get();

        List<GrantedAuthority> authorityList = new ArrayList<>();



        return new User(user.getEmail() , user.getPassword() ,authorityList);



      }else {
          throw new BadCredentialsException("Bad credentials");
      }

    }




}
