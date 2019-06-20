package com.handel.forum.repository;

import com.handel.forum.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("postRepository")
public interface PostRepository
        extends JpaRepository<Post, Integer>
{
    @Query(value = "select * from POST order by POST_ID desc", nativeQuery = true)
    List<Post> getAllPosts();
}
//    order by POST_ID desc