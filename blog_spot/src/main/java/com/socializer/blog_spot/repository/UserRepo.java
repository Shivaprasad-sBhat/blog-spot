package com.socializer.blog_spot.repository;

import com.socializer.blog_spot.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer> {

    public Optional<Users> findByEmail(String email);

}
