package com.sudokubase.controllers;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String home() {
       
        return "home";
    }

    @GetMapping("/dashboard")
    public String user(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        return "dashboard";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/privacy")
    public String showPolicy() {
        return "policy";
    }

}
