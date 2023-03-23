package com.socializer.blog_spot.controller;

import com.socializer.blog_spot.model.Blog;
import com.socializer.blog_spot.model.Likes;
import com.socializer.blog_spot.service.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {


    @Autowired
    private BlogServiceImpl blogService;

    @GetMapping("/hello")
    public String hello(){
        return "wellcome to blog spot";
    }


    @PostMapping("/blogs")
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) throws Exception {

        Blog newBlog = blogService.createBlog(blog);
        return new ResponseEntity<>(newBlog, HttpStatus.CREATED);

    }


    @PostMapping("/likes")
    public ResponseEntity<Integer> chekLikes(@RequestBody Likes likes){

        Integer totalLikes =    blogService.checkLikes(likes);

        return new ResponseEntity<>(totalLikes,HttpStatus.OK);

    }

}
