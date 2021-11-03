package com.sudokubase.controllers;

import com.sudokubase.entity.Countries;
import com.sudokubase.entity.Users;
import com.sudokubase.repository.CountryRepository;
import com.sudokubase.repository.UserRepository;
import java.security.Principal;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/profile")
    public String showProfile(Principal principal, Model model) {
        List<Countries> countryList = countryRepository.findAll();

        Users tempUser = userRepository.findByUsernameIgnoreCase(principal.getName());
        model.addAttribute("tempUser", tempUser);

        model.addAttribute("countries", countryList);
        return "profile";
    }

    @PostMapping("/save")
    public String updateUser(@Valid @ModelAttribute("tempUser") Users newUser, BindingResult bindingResult,
            Model model, Principal principal) {

        if (bindingResult.hasErrors()) {
            return "profile";
        }
        Users temp1User = userRepository.findByUsernameIgnoreCase(principal.getName());
        Users tempUser = userRepository.findByUsernameIgnoreCase(temp1User.getUsername());
        if (tempUser != null && !(tempUser.getUsername().equals(temp1User.getUsername()))) {
            model.addAttribute("error1", "This username already exists!");
            return "register";
        }

        temp1User.setUsername(newUser.getUsername());
        temp1User.setFname(newUser.getFname());
        temp1User.setLname(newUser.getLname());
        temp1User.setCountry(newUser.getCountry());

        userRepository.save(temp1User);

        return "dashboard";
    }

    @GetMapping("/delete")
    public String showDelete() {
        return "delete";
    }
    
    @PostMapping("/delete")
    public String delAccount(Principal principal) {
        Users tempUser = userRepository.findByUsernameIgnoreCase(principal.getName());
        tempUser.setEnabled(false);
        userRepository.save(tempUser);
      
        SecurityContextHolder.clearContext();
        return "home";
    
    }
}
