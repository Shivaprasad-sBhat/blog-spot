package com.socializer.blog_spot.service;

import com.socializer.blog_spot.dto.ArticleDto;

public interface ArticleService {

    public ArticleDto writeArticle(ArticleDto articleDto);

    public ArticleDto updateArticle(ArticleDto articleDto);

}
