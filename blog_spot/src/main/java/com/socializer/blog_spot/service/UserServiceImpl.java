package com.socializer.blog_spot.service;

import com.socializer.blog_spot.dto.UsersDto;
import com.socializer.blog_spot.model.Users;
import com.socializer.blog_spot.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
        return null;
    }

    @Override
    public String updateUserPassword(String password) {
        return null;
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
