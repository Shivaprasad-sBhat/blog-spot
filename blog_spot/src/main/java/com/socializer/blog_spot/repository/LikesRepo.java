package com.socializer.blog_spot.repository;

import com.socializer.blog_spot.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikesRepo extends JpaRepository<Likes,Integer> {

   // @Query("select l from Likes where userId=?1 and blogId=?2")
    public Optional<Likes> findByUserIdAndBlog(Integer userId,Integer blogId);

}
