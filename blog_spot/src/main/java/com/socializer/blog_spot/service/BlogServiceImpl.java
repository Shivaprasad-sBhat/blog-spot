package com.socializer.blog_spot.service;

import com.socializer.blog_spot.model.Blog;
import com.socializer.blog_spot.model.Likes;
import com.socializer.blog_spot.model.Users;
import com.socializer.blog_spot.repository.BlogRepo;
import com.socializer.blog_spot.repository.LikesRepo;
import com.socializer.blog_spot.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl {

    @Autowired
    private BlogRepo blogRepo;

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private LikesRepo likesRepo;





    public Blog createBlog(Blog blog) throws Exception {

        blog.setPostingDate(LocalDateTime.now());
        Users user = userRepo.findById(102).orElseThrow(()->new Exception("user not found"));
        user.getBlogs().add(blog);


        return blogRepo.save(blog);
    }


    public  Integer checkLikes(Likes likes){

        Optional<Likes> like =   likesRepo.findByUserIdAndBlog(likes.getUserId(),likes.getBlog().getBlogId());

        if(like.get()!=null){

            likesRepo.delete(like.get());

        }else{

            likesRepo.save(likes);

        }
        List<Likes> totalLikes = likesRepo.findAll();

        return totalLikes.size();
    }




}
