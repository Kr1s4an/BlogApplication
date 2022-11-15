package com.example.Blogapplication.controller;

import com.example.Blogapplication.model.Post;
import com.example.Blogapplication.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable Long id, Model model) {

        Optional<Post> optionalPostModel = postService.getById(id);
        if (optionalPostModel.isPresent()) {
            Post post = optionalPostModel.get();
            model.addAttribute("post", post);
            return "post";
        } else {
            return "404";
        }
    }
}
