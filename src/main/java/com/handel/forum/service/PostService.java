package com.handel.forum.service;

import com.handel.forum.model.Post;
import com.handel.forum.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service("postService")
public class PostService {

    @Autowired
    UserService userService;

    @Autowired
    private PostRepository postRepository;

    public Post savePost(Post post){
        return postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return new ArrayList<>(postRepository.getAllPosts());
    }

    public void deletePost(Integer id) {
        System.out.println("ID posta "+id);
        postRepository.deletePostByPost_Id(id);
    }

    public Post getPost(Integer id) {
        return postRepository.getPostById(id);
    }

    public void updatePost(Post post) {
        Post updatedPost = post;
        updatedPost.setUser(userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName()));
        updatedPost.setDate(LocalDateTime.now());
        postRepository.deletePostByPost_Id(post.getPostId());
        postRepository.save(updatedPost);
    }
}
