package com.simpleJWTAuth.assignment.controller;

import com.simpleJWTAuth.assignment.model.User;
import com.simpleJWTAuth.assignment.service.JwtService;
import com.simpleJWTAuth.assignment.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;

    public AuthController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {

        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User loggedInUser = userService.login(
                user.getUsername(),
                user.getPassword()
        );

        return jwtService.generateToken(loggedInUser.getUsername());
    }

    @GetMapping("/hello")
    public String hello() {

        return "Hello, authenticated user!";
    }
}