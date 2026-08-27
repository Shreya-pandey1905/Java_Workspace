package com.userAuthentication.UserAuthentication.controller;

import com.userAuthentication.UserAuthentication.dto.LoginReqDTO;
import com.userAuthentication.UserAuthentication.dto.ProfileUpdateDto;
import com.userAuthentication.UserAuthentication.dto.UserAuthRequestDto;
import com.userAuthentication.UserAuthentication.dto.UserAuthResponseDto;
import com.userAuthentication.UserAuthentication.entity.UserAuthEntity;
import com.userAuthentication.UserAuthentication.service.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
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
    public ResponseEntity<UserAuthResponseDto> registerUser(@RequestBody UserAuthRequestDto requestDto){
     UserAuthResponseDto userAuthResponseDto= userService.registerUser(requestDto);
     return ResponseEntity.ok().body(userAuthResponseDto);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<UserAuthResponseDto> getById(@PathVariable Long id){
        UserAuthResponseDto userAuthResponseDto = userService.getById(id);
        return ResponseEntity.ok().body(userAuthResponseDto);
    }

    @PostMapping("/loginUser")
    public ResponseEntity<UserAuthResponseDto> loginUser(@RequestBody LoginReqDTO request){
        UserAuthResponseDto userAuthResponseDto = userService.loginUser(request);
        return ResponseEntity.ok().body(userAuthResponseDto);
    }

    @GetMapping("/profile")
    public ResponseEntity<UserAuthResponseDto> profile(@AuthenticationPrincipal UserDetails userDetails){
        return ResponseEntity.ok(userService.getUserProfile(userDetails.getUsername()));
    }

    @PatchMapping("/update")
    public ResponseEntity<UserAuthResponseDto> update(@RequestBody ProfileUpdateDto profileUpdateDto,@AuthenticationPrincipal UserDetails userDetails){
        UserAuthResponseDto userAuthResponseDto= userService.updateUser(profileUpdateDto,userDetails);
        return ResponseEntity.ok(userAuthResponseDto);
    }


}
