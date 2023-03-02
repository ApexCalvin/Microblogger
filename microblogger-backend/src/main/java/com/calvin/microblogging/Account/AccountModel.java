package com.calvin.microblogging.Account;

import com.calvin.microblogging.Post.PostModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class AccountModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String handle;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @OneToMany(mappedBy = "assocAccount")
    private List<PostModel> userPosts;

    public AccountModel() {}

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

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public List<PostModel> getUserPosts() { return userPosts; }

    public void setUserPosts(List<PostModel> userPosts) { this.userPosts = userPosts; }
}
