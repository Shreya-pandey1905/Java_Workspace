package com.userAuthentication.UserAuthentication.service;

import com.userAuthentication.UserAuthentication.dto.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserAuthResponseDto registerUser(UserAuthRequestDto requestDto);

    List<UserAuthResponseDto> findAll();

    UserAuthResponseDto getById(Long id);

    LoginResponseDto loginUser(LoginReqDTO reqDTO);

    UserAuthResponseDto updateUser(ProfileUpdateDto request, UserDetails userDetails);

    UserAuthResponseDto getUserProfile(String username);

}
