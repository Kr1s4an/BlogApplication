package com.example.Blogapplication.controller;

import com.example.Blogapplication.model.PostModel;
import com.example.Blogapplication.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String home(Model model){
        List<PostModel> posts= postService.getAll();
        model.addAttribute("posts", posts);
        return "home";
    }
}