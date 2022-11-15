package com.example.Blogapplication.config;

import com.example.Blogapplication.model.Account;
import com.example.Blogapplication.model.Post;
import com.example.Blogapplication.service.AccountService;
import com.example.Blogapplication.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeeDataConfig implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @Override
    public void run(String... args) throws Exception {
        List<Post> posts = postService.getAll();
        if(posts.size()==0){


            Account account1 = new Account();
            account1.setFirstName("Kr1s4an");
            account1.setLastName("Unknown");
            account1.setEmail("admin@gmail.com");
            account1.setPassword("1000101");

            Account account2 = new Account();
            account2.setFirstName("a40o");
            account2.setLastName("Nobody");
            account2.setEmail("jester@gmail.com");
            account2.setPassword("100110");

            accountService.save(account1);
            accountService.save(account2);

            Post post1 = new Post();
            post1.setTitle("Seasons");
            post1.setBody("There are 4 seasons " +
                    "summer" +
                    " spring" +
                    " winter" +
                    " and fall");
            post1.setAccount(account1);

            Post post2 = new Post();
            post2.setTitle("Primary PC colors ");
            post2.setBody("There are 3 primary colors " +
                    "red" +
                    " green" +
                    " blue" +
                    " they are called RGB");
            post2.setAccount(account2);

            postService.save(post1);
            postService.save(post2);



        }
    }

}
