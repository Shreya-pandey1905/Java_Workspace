package com.simpleJWTAuth.assignment.controller;

import ch.qos.logback.core.model.Model;
import com.simpleJWTAuth.assignment.model.AuthResponse;
import com.simpleJWTAuth.assignment.model.User;
import com.simpleJWTAuth.assignment.service.JwtService;
import com.simpleJWTAuth.assignment.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
    public AuthResponse login(@RequestBody User user) {

        User loggedInUser = userService.login(user.getUsername(),user.getPassword());

        String accessToken = jwtService.generateAccessToken(
                        loggedInUser.getUsername() );

        String refreshToken =jwtService.generateRefreshToken(
                        loggedInUser.getUsername() );

        return new AuthResponse(
                accessToken,
                refreshToken
        );
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, authenticated user!";
    }



}