package com.userAuthentication.UserAuthentication.service;

import com.userAuthentication.UserAuthentication.dto.LoginReqDTO;
import com.userAuthentication.UserAuthentication.dto.ProfileUpdateDto;
import com.userAuthentication.UserAuthentication.dto.UserAuthRequestDto;
import com.userAuthentication.UserAuthentication.dto.UserAuthResponseDto;
import com.userAuthentication.UserAuthentication.entity.UserAuthEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserAuthResponseDto registerUser(UserAuthRequestDto requestDto);

    List<UserAuthResponseDto> findAll();

    UserAuthResponseDto getById(Long id);

    UserAuthResponseDto loginUser(LoginReqDTO reqDTO);

    UserAuthResponseDto updateUser(ProfileUpdateDto request, UserDetails userDetails);

    UserAuthResponseDto getUserProfile(String username);

}
