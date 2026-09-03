package com.javaJs.JavaFullStackWithJS.controller;

import com.javaJs.JavaFullStackWithJS.entity.Users;
import com.javaJs.JavaFullStackWithJS.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    public final UserService userService;

    @GetMapping
    public List<Users> getAll(){
        return userService.findAll();
    }

    @PostMapping
    public Users addUser(@RequestBody Users users){
        return userService.addUser(users);
    }

}
