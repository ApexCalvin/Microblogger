package com.calvin.microblogging.Account;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //@Column(nullable = false)
    private String handle;
    private String name;
    private String username;
    private String password;
    //private List<Post> userPosts;

    public Account() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Post> getUserPosts() {
//        return userPosts;
//    }
//
//    public void setUserPosts(List<Post> userPosts) {
//        this.userPosts = userPosts;
//    }
}
