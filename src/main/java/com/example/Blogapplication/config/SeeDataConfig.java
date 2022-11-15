package com.example.Blogapplication.config;

import com.example.Blogapplication.model.PostModel;
import com.example.Blogapplication.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeeDataConfig implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Override
    public void run(String... args) throws Exception {
        List<PostModel> posts = postService.getAll();
        if(posts.size()==0){
            PostModel post1 = new PostModel();
            post1.setTitle("Seasons");
            post1.setBody("There are 4 seasons " +
                    "summer" +
                    " spring" +
                    " winter" +
                    " and fall");
            PostModel post2 = new PostModel();
            post2.setTitle("Primary PC colors ");
            post2.setBody("There are 3 primary colors " +
                    "red" +
                    " green" +
                    " blue" +
                    " they are called RGB");
            postService.save(post1);
            postService.save(post2);

        }
    }

}
