package com.socializer.blog_spot.service;

import com.socializer.blog_spot.dto.BlogDto;
import com.socializer.blog_spot.dto.UsersDto;
import com.socializer.blog_spot.model.Blog;
import com.socializer.blog_spot.model.Likes;

import java.util.List;

public interface BlogService {

    public BlogDto createBlog(BlogDto blogDto) ;
    public BlogDto updateBlog(BlogDto  blogDto) ;
    public Integer addLikes(BlogDto blogDto);
    public  Integer checkLikes(Likes likes);
    public List<BlogDto> featuredBlog();


}
