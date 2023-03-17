package com.socializer.blog_spot.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer userId;
    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    private Integer follwers;

    @OneToMany(mappedBy = "users",cascade = CascadeType.ALL)
    private List<Blog> blogs;

    @ElementCollection
    private List<Users> followerDetails = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Blog> bookmarks = new ArrayList<>();

    @ElementCollection
    private List<String> notifications = new ArrayList<>();


}
