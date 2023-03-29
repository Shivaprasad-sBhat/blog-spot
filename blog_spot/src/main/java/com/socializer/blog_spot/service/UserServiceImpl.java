package com.socializer.blog_spot.service;

import com.socializer.blog_spot.dto.UsersDto;
import com.socializer.blog_spot.exception.UsersException;
import com.socializer.blog_spot.model.Users;
import com.socializer.blog_spot.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UsersDto registerUser(UsersDto usersDto) {

        Users users = usersDtoToUser(usersDto);
        users = userRepo.save(users);

        return usersToUserDto(users);
    }

    @Override
    public UsersDto updateUserDetails(UsersDto usersDto) {
        String principle = SecurityContextHolder.getContext().getAuthentication().getName();
        Users users = userRepo.findByEmail(principle).orElseThrow(() -> new UsersException("Bad credentials"));

        users.setFirstName(usersDto.getFirstName());
        users.setLastName(usersDto.getLastName());
        users.setEmail(usersDto.getEmail());

        users = userRepo.save(users);

        return usersToUserDto(users);

    }

    @Override
    public String updateUserPassword(String password) {
        String principle = SecurityContextHolder.getContext().getAuthentication().getName();
        Users users = userRepo.findByEmail(principle).orElseThrow(() -> new UsersException("Bad credentials"));

        users.setPassword(password);
        userRepo.save(users);

        return "Password updeted";
    }

        public Users usersDtoToUser(UsersDto usersDto){

            Users users = modelMapper.map(usersDto, Users.class);

            return users;

        }

       public UsersDto usersToUserDto(Users users){

           UsersDto usersDto = modelMapper.map(users, UsersDto.class);

           return usersDto;

    }

}
