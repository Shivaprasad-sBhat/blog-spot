package com.socializer.blog_spot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer articleId;

    private String header;
    private String content;
    private String imgURL;

    @ElementCollection
    private List<String> tags = new ArrayList<>();



    @OneToOne
    private Blog blog;
}
