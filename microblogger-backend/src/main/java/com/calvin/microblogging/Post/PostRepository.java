
package com.calvin.microblogging.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    // TODO - create custom queries for: findPostsDESC
    //                                   findPostsByAccountID
    //                                   findPostsByHashtagID
}