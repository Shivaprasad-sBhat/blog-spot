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
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer blogId;
    private LocalDateTime postingDate;
    private Integer likes;
    private Integer disLikes;

    @OneToMany(mappedBy = "blogs",cascade = CascadeType.ALL)
    private List<Comments> comments =new ArrayList<>();


    @OneToOne(mappedBy = "blog",cascade = CascadeType.ALL)
    private Article article;

    @ManyToOne(cascade = CascadeType.ALL)
    private Users users;






}
