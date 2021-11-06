package com.sudokubase.controllers;

import com.sudokubase.entity.ConfirmationToken;
import com.sudokubase.entity.Roles;
import com.sudokubase.entity.Users;
import com.sudokubase.repository.ConfirmationTokenRepository;
import com.sudokubase.repository.UserRepository;
import com.sudokubase.service.SendGridService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;
    @Autowired
    private SendGridService sendGridService;

    @GetMapping("/register")
    public String showRegistration(@ModelAttribute("newUser") Users newUser, Model model) {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("newUser") Users newUser, BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        if (userRepository.findByUsernameIgnoreCase(newUser.getUsername()) != null) {
            model.addAttribute("error1", "This username already exists!");
            return "register";
        }
        if (userRepository.findByEmailIgnoreCase(newUser.getEmail()) != null) {
            model.addAttribute("error2", "This email is already being used!");
            return "register";
        }

        Roles userRole = new Roles();
        userRole.setId(4);
        userRole.setRole("ROLE_USER");
        newUser.setRole(userRole);
        newUser.setElo(1000);
        newUser.setEnabled(false);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        System.out.println(">>>>>>>>>>>>>>>> Sending mail to user:");
        System.out.println(newUser.toString());
        userRepository.save(newUser);

        ConfirmationToken confirmationToken = new ConfirmationToken(newUser);

        confirmationTokenRepository.save(confirmationToken);

        String messageBody = "To confirm your account, please click here:<br> "
                + "https://www.sudokubase.com/confirm-account?token=" + confirmationToken.getConfirmationToken()
                + "<br>This link will expire in 24 hours.";

        sendGridService.sendEmailWithSendGrid(messageBody, newUser.getEmail(),"SudokuBase - Confirm your Account");

        model.addAttribute("email", newUser.getEmail());

        Runnable exampleRunnable = () -> {
            confirmationTokenRepository.delete(confirmationToken);
            Users tempUser = userRepository.findByUsernameIgnoreCase(newUser.getUsername());
            if (tempUser != null && tempUser.getEnabled() == false) {
                userRepository.delete(tempUser);
            }
        };

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(exampleRunnable, 86400, TimeUnit.SECONDS);

        return "activation_email";
    }

    @GetMapping("/confirm-account")
    public String confirmUserAccount(Model model, @RequestParam("token") String confirmationToken) {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if (token != null) {
            confirmationTokenRepository.delete(token);
            Users user = userRepository.findByEmailIgnoreCase(token.getUser().getEmail());
            System.out.println(">>>>>>>>>>> user to be evaluated: " + user);
            if (user.getEnabled()) { // user is here to change his password
                model.addAttribute("tempUser", user);
                return "changepwd";
            } else { // user is here to activate his account
                model.addAttribute("tempUser", user);
                user.setEnabled(true);
            }
            userRepository.save(user);
            return "activation_success";

        }
        return "expired";
    }

    @GetMapping("/recover")
    public String showForgot(Model model) {
        model.addAttribute("userEmail", new Users());
        return "forgot";
    }

    @PostMapping("/recover")
    public String showForgotSuccess(@ModelAttribute("userEmail") Users tempUser, Model model) {

        Users temp1 = userRepository.findByEmailIgnoreCase(tempUser.getEmail());
        System.out.println(">>>>>> USER REQUESTS PASSWORD RESET: " + temp1);
        if (temp1!=null && temp1.getEnabled()) { // in order to avoid an inactive account being activated
            ConfirmationToken confirmationToken = new ConfirmationToken(temp1);
            confirmationTokenRepository.save(confirmationToken);
            String messageBody = "Click to the following link to reset your password<br> "
                    + "https://www.sudokubase.com/confirm-account?token=" + confirmationToken.getConfirmationToken()
                    + "<br>This link will expire in 15 minutes";

            sendGridService.sendEmailWithSendGrid(messageBody, temp1.getEmail(),"SudokuBase - Password Reset");
            
            Runnable exampleRunnable = () -> {
            confirmationTokenRepository.delete(confirmationToken);
        };

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(exampleRunnable, 900, TimeUnit.SECONDS);
            
            model.addAttribute("email", temp1.getEmail());
            return "reset_email";
        }
        return "home";
    }

    @PostMapping("/newpass")
    public String changePass(@ModelAttribute("tempUser") Users tempUser) {
        Users temp1 = userRepository.findByEmailIgnoreCase(tempUser.getEmail());
        temp1.setPassword(passwordEncoder.encode(tempUser.getPassword()));
        userRepository.save(temp1);
        return "home";
    }
}
