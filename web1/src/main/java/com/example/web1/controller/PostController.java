package com.example.web1.controller;

import com.example.web1.model.MyUserDetails;
import com.example.web1.model.Post;
import com.example.web1.service.IPostService;
import com.example.web1.service.MyUserDetailsService;
import com.example.web1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class PostController {
    @Autowired
    private IPostService postService;

    @Autowired
    private MyUserDetailsService myuserDetailsService;

    @GetMapping("/create-post")
    public String createPost(Model model, @ModelAttribute(name = "post") Post post, Principal principal){
        model.addAttribute("user", myuserDetailsService.getUserbyEmail(principal.getName()));
        return Route.Create_POSTS;
    }

    @PostMapping("/create-post/save")
    public String savePost(@ModelAttribute(name = "post") Post post, Principal principal){
        post.prePersist();
        post.setAuthor(myuserDetailsService.getUserbyEmail(principal.getName()));
        postService.save(post);
        return Route.REDIRECT_HOME;
    }

    @GetMapping("/delete-post")
    public String deletePost(@RequestParam(name = "id") Long id){
        postService.delete(id);
        return Route.REDIRECT_HOME;
    }

    @GetMapping("/page/{id}")
    public String getPost(@PathVariable("id") long id, Model model, Principal principal){
        model.addAttribute("user", myuserDetailsService.getUserbyEmail(principal.getName()));
        model.addAttribute("post", postService.findById(id));
        return Route.Page;
    }
}
