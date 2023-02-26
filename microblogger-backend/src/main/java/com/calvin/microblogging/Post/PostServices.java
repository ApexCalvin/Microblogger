
package com.calvin.microblogging.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServices {
    @Autowired
    PostRepository postRepository;

    /*
    Create  |   Save                    |   Post
    Read    |   Get (Singular/Plural)   |   Get
    Update  |   Save                    |   Put
    Delete  |   Delete                  |   Delete
     */

    public void savePost(Post post) {
        postRepository.save(post);
    }

    public Post getPostById(Integer id) {
        return postRepository.findById(id).get();
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public void deletePostById(Integer id) {
        postRepository.deleteById(id);
    }
}