package com.socializer.blog_spot.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer commentId;

    private String comments;

    private LocalDateTime postingDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Users users;

    @ManyToOne(cascade = CascadeType.ALL)
    private Blog blogs;


}
