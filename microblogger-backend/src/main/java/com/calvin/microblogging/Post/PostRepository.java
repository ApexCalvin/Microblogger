package com.calvin.microblogging.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostModel, Integer> {
    // TODO - create custom queries for: findPostsDESC
    //                                   findPostsByAccountID
    //                                   findPostsByHashtagID

    /*
        @Query(name = "query_name", nativeQuery = true)
        List<PostListDTO> findPostsByAccountId(String handle);

        @Query(name = "query_name2", nativeQuery = true)
        List<PostListDTO> findPostsByHashtagId(String hashtag);

        @Query(name = "query_name4", nativeQuery = true)
        List<PostListDTO> findPostsDESC();
     */
//    @Query(name = "findPostsDESC", nativeQuery = true)
//    List<PostModel> findPostsDESC();
}