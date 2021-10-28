package com.sudokubase.controllers;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
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
        return "pp";
    }

}
