package com.socializer.blog_spot.dto;

import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {

    private Integer articleId;

    private String header;
    private String content;
    private String imgURL;
    private List<String> tags = new ArrayList<>();



}
