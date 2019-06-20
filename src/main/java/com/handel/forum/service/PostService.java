package com.handel.forum.service;

import com.handel.forum.model.Post;
import com.handel.forum.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("postService")
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post savePost(Post post){
        return postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return new ArrayList<>(postRepository.getAllPosts());
    }
}
