package com.example.Blogapplication.service;

import com.example.Blogapplication.model.PostModel;
import com.example.Blogapplication.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Optional<PostModel> getById(Long id){
        return postRepository.findById(id);
    }
    public List<PostModel> getAll(){
        return postRepository.findAll();
    }
    public PostModel save(PostModel post){
        if(post.getId()== null){
            post.setCreatedAt(LocalDateTime.now());
        }
        return postRepository.save(post);
    }
}
