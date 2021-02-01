package com.example.web1.controller;


import com.example.web1.model.MyUserDetails;
import com.example.web1.model.User;
import com.example.web1.service.IPostService;
import com.example.web1.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class HomeController {
    @Autowired
    private IPostService postService;

    @Autowired
    private MyUserDetailsService myuserDetailsService;

    @GetMapping
    public String home(Model model, Principal principal){
        try {
            User user = myuserDetailsService.getUserbyEmail(principal.getName()) ;
            if (user != null) {
                model.addAttribute("user", user);
            }
        } catch (Exception e) {
            model.addAttribute("errorMessage", e);
        }
        model.addAttribute("posts",  postService.getAllPost());
        return Route.HOME;
    }

}
