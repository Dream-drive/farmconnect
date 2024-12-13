package com.facon.farm.controller;

import com.facon.farm.model.User;
import com.facon.farm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Display signup page
    @RequestMapping("/signup")
    public String showSignupForm() {
        return "signup"; // This will return the signup.html page
    }

    // Handle signup form submission
    @PostMapping("/register")
    public String registerUser(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        // Save user to the database
        User newUser = new User(name, email, password);
        userRepository.save(newUser);

        return "redirect:/"; // Redirect to homepage after successful signup
    }
}
