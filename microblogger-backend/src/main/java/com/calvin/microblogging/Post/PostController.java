package com.calvin.microblogging.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/post")
@CrossOrigin("http://localhost:8080") //TODO - change localhost:3000 to send data to frontend
public class PostController {
    @Autowired
    PostServices postServices;
    //TODO - implements Data Transfer Objects (DTO)

    @PostMapping("/add")
    public String addPost(@RequestBody Post post) {
        //TODO - createPost error handling
        //Boolean exist = postServices.savePost(post);
        //if(exist) return "Post has been created.";
        return "Failed to create post.";
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Integer id) {
        postServices.deletePostById(id);
        return "Post ID "+id+" has been deleted.";
    }

    @GetMapping("/all")
    public List<Post> findAllPosts() {
        return postServices.getAllPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findPostByAccountId(@PathVariable Integer id) {
        //TODO - learn about Response Entities
        try {
            Post test = postServices.getPostById(id);
            return new ResponseEntity<>(test, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> editPost(@PathVariable Integer id, @RequestBody Post post) {
        //TODO - figure out how to edit posts
        try {
            Post test = postServices.getPostById(id);
            return new ResponseEntity<>(test, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}