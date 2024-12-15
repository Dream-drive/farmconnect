package com.facon.farm.controller;

import com.facon.farm.model.User;
import com.facon.farm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Display signup page
    @RequestMapping("/signup")
    public String showSignupForm() {
        return "redirect:/signup.html"; // Serve the signup.html file directly from static folder
    }

    // Handle signup form submission
    @PostMapping("/register")
    public String registerUser(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        // Save user to the database
        User newUser = new User(name, email, password);
        userRepository.save(newUser);

        return "redirect:/"; // Redirect to homepage after successful signup
    }

    // Display login page
    @RequestMapping("/login")
    public String showLoginForm() {
        return "redirect:/login.html"; // Serve the login.html file directly from static folder
    }

    // Handle login form submission
    @PostMapping("/login")
    public String loginUser(@RequestParam String email, @RequestParam String password, Model model) {
        // Find user by email
        User user = userRepository.findByEmail(email);

        // Check if user exists and the password matches
        if (user != null && user.getPassword().equals(password)) {
            // Successful login
            model.addAttribute("user", user); // Add user to the session or model
            return "redirect:/index.html"; // Serve the index.html file directly from static folder
        } else {
            // Invalid credentials
            model.addAttribute("error", "Invalid email or password");
            return "redirect:/login.html"; // Return to login page with error message
        }
    }
}
