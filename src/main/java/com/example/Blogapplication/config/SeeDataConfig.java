package com.example.Blogapplication.config;

import com.example.Blogapplication.model.Account;
import com.example.Blogapplication.model.Authority;
import com.example.Blogapplication.model.Post;
import com.example.Blogapplication.repository.AuthorityRepository;
import com.example.Blogapplication.service.AccountService;
import com.example.Blogapplication.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SeeDataConfig implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Post> posts = postService.getAll();
        if(posts.size()==0){

            Authority user = new Authority();
            user.setName("ROLE_USER");
            authorityRepository.save(user);

            Authority admin = new Authority();
            admin.setName("ROLE_ADMIN");
            authorityRepository.save(admin);

            Account account1 = new Account();
            account1.setFirstName("Kr1s4an");
            account1.setLastName("Unknown");
            account1.setEmail("admin@gmail.com");
            account1.setPassword("1000101");
            Set<Authority> authorities1 = new HashSet<>();
            authorityRepository.findById("ROLE_USER").ifPresent(authorities1::add);
            account1.setAuthorities(authorities1);

            Account account2 = new Account();
            account2.setFirstName("a40o");
            account2.setLastName("Nobody");
            account2.setEmail("jester@gmail.com");
            account2.setPassword("100110");
            Set<Authority> authorities2 = new HashSet<>();
            authorityRepository.findById("ROLE_USER").ifPresent(authorities2::add);
            authorityRepository.findById("ROLE_ADMIN").ifPresent(authorities2::add);
            account2.setAuthorities(authorities2);

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
