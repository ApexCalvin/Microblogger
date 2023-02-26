
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

    public void savePost(Post post) { postRepository.save(post); }

    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    public Post findPostById(Integer id) { return postRepository.findById(id).get(); }

    public void deletePostById(Integer id) {
        postRepository.deleteById(id);
    }
}