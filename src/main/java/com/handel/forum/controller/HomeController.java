package com.handel.forum.controller;

import com.handel.forum.model.ForumUsers;
import com.handel.forum.model.Post;
import com.handel.forum.service.PostService;
import com.handel.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    UserService userService;
    @Autowired
    PostService postService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home()
    {
        List<Post> allPost = postService.getAllPosts();
        ModelAndView modelAndView= new ModelAndView();
        ForumUsers user = userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        modelAndView.addObject("allPosts", allPost);
        modelAndView.addObject("user", user);
        modelAndView.addObject("post", new Post());
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView createPost(Post post){
        ModelAndView modelAndView= new ModelAndView();
        System.out.println("POST: --> " + post);
        if(post != null){
            post.setUser(userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName()));
            post.setDate(LocalDateTime.now());
            postService.savePost(post);
            modelAndView.setViewName("redirect:/");
        }else {
            modelAndView.setViewName("access-denied.html");
        }
        return modelAndView;
    }
}
