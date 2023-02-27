
package com.calvin.microblogging.Post;

import com.calvin.microblogging.Account.AccountModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    public String savePost(PostModel post) {
        if(post.getDateTime() == null) post.setDateTime(new Date());
        postRepository.save(post);
        return "Post has been saved.";
    }

    public List<PostModel> findAllPosts() { return postRepository.findAll(); }

    public PostModel findPostById(Integer id) { return postRepository.findById(id).get(); }

    public String deletePostById(Integer id) {
        Optional<PostModel> exist = postRepository.findById(id);

        if(exist.isPresent()) {
            postRepository.deleteById(id);
            return "Post ID: "+id+" has been deleted.";
        }
        return "Post ID: "+id+" does not exist.";
    }

    public String editPostById(Integer id, PostModel postWithEdits) {
        Optional<PostModel> exist = postRepository.findById(id);

        if(exist.isPresent()) {
            if(postWithEdits.getId() != null) {
                postWithEdits.setEdited(true);
                postWithEdits.setDateTime(exist.get().getDateTime());
                postRepository.save(postWithEdits);
                return "Post ID: "+id+" has been edited.";
            }
            return "JSON object is missing a post ID.";
        }
        return "Failed to edit post ID: "+id;
    }
}