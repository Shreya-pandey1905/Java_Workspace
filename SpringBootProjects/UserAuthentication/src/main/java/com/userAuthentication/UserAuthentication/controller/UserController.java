package com.userAuthentication.UserAuthentication.controller;

import com.userAuthentication.UserAuthentication.dto.UserAuthRequestDto;
import com.userAuthentication.UserAuthentication.dto.UserAuthResponseDto;
import com.userAuthentication.UserAuthentication.entity.UserAuthEntity;
import com.userAuthentication.UserAuthentication.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/getAll")
    public ResponseEntity<List<UserAuthResponseDto>> getAll(){
        List<UserAuthResponseDto> userAuthResponseDto= userService.findAll();
        return ResponseEntity.ok().body(userAuthResponseDto);
    }

    @PostMapping("/registerUser")
    public ResponseEntity<UserAuthResponseDto> registerUser(@Valid @RequestBody UserAuthRequestDto requestDto){
     UserAuthResponseDto userAuthResponseDto= userService.registerUser(requestDto);
     return ResponseEntity.ok().body(userAuthResponseDto);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<UserAuthResponseDto> getById(@PathVariable Long id){
        UserAuthResponseDto userAuthResponseDto = userService.getById(id);
        return ResponseEntity.ok().body(userAuthResponseDto);
    }



}
