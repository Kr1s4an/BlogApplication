package com.example.Blogapplication.controller;

import com.example.Blogapplication.model.Account;
import com.example.Blogapplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        Account account = new Account();
        model.addAttribute("account", account);
        return "register";
    }

    @PostMapping("/register")
    public String registerNewAccount(@ModelAttribute Account account){
        accountService.save(account);
        return "redirect:/";
    }

}
