package com.example.JWTSpringBoot.controller;


import com.example.JWTSpringBoot.service.JwtService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password) {

        // Simple demo authentication
        if (username.equals("tanvir")
                && password.equals("1234")) {

            return jwtService.generateToken(username);
        }

        return "Invalid username or password";
    }
}