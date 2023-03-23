package com.socializer.blog_spot.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String firstName;
    private String lastName;
    
    
    @Column(unique = true)
    private String email;

    private String password;
    private Integer follwers;

    @OneToMany(mappedBy = "users",cascade = CascadeType.ALL)
    private List<Blog> blogs = new ArrayList<>();

    @ElementCollection
    private List<Users> followerDetails = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Blog> bookmarks = new ArrayList<>();

    @ElementCollection
    private List<String> notifications = new ArrayList<>();


}
