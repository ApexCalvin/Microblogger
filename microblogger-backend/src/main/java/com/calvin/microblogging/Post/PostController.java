package com.calvin.microblogging.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/post")
@CrossOrigin("http://localhost:8080") //localhost:3000 to send data to frontend
public class PostController {
    @Autowired
    PostServices postServices;

    @PostMapping("/add")
    public String addPost(@RequestBody PostModel post) { return postServices.savePost(post); }

    @GetMapping("/all")
    public List<PostModel> getAllPosts() { return postServices.findAllPosts(); }

    @GetMapping("/{id}")
    public ResponseEntity<PostModel> getPostByAccountId(@PathVariable Integer id) {
        try {
            PostModel post = postServices.findPostById(id);
            return new ResponseEntity<>(post, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Integer id) { return postServices.deletePostById(id); }

    @PutMapping("/{id}")
    public String editPostById(@PathVariable Integer id, @RequestBody PostModel postWithEdits) {
        return postServices.editPostById(id, postWithEdits);
    }

//    @Autowired
//    PostRepository postRepository;
//
//    @GetMapping("/all/desc")
//    public List<PostModel> getAllPostsDESC() { return postRepository.findPostsDESC(); }
}