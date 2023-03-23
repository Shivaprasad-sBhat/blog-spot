package com.socializer.blog_spot.service;

import com.socializer.blog_spot.model.Blog;
import com.socializer.blog_spot.model.Likes;

public interface BlogService {

    public Blog createBlog(Blog blog) throws Exception ;
    public  Integer checkLikes(Likes likes);
}
