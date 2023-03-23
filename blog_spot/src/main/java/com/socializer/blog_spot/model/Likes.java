package com.socializer.blog_spot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer likesId;
    private Integer userId;

    @ManyToOne(cascade = CascadeType.ALL)
    private Blog blog;


}
