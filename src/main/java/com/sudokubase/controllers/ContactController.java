
package com.sudokubase.controllers;

import com.sudokubase.service.SendGridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    @Autowired
    private SendGridService sendGridService;
    
    @GetMapping("/contact")
    public String showContactForm() {
        return "contact";
    }
    
    @PostMapping("/contact")
    public String sendEmail(@RequestParam String name,@RequestParam String email, @RequestParam String message) {
        System.out.println(name);
        System.out.println(email);
        System.out.println(message);
        sendGridService.sendEmailWithSendGrid("name: " + name + "<br>" + "email: " + email + "<br>"+ "message: " + message, "koutsouflakis.stefanos@gmail.com","SudokuBase - User Message");
        return "home";
    }
}
