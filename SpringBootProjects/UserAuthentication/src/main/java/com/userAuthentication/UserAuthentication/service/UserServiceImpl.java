package com.userAuthentication.UserAuthentication.service;

import com.userAuthentication.UserAuthentication.config.ModelMapperConfig;
import com.userAuthentication.UserAuthentication.config.SecurityFilterConfig;
import com.userAuthentication.UserAuthentication.dto.UserAuthRequestDto;
import com.userAuthentication.UserAuthentication.dto.UserAuthResponseDto;
import com.userAuthentication.UserAuthentication.entity.UserAuthEntity;
import com.userAuthentication.UserAuthentication.repository.userAuthRepo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    userAuthRepo userAuthRepo;

    @Autowired
    ModelMapper modelMapper;

    private final SecurityFilterConfig securityFilterConfig;




    @Override
    public UserAuthResponseDto registerUser(UserAuthRequestDto requestDto) {

        UserAuthEntity user= modelMapper.map(requestDto,UserAuthEntity.class);
        user.setPassword(securityFilterConfig.passwordEncrypt().encode(requestDto.getPassword()));

        UserAuthEntity userAuthEntity= userAuthRepo.save(user);
         return modelMapper.map(userAuthEntity,UserAuthResponseDto.class);
    }

    @Override
    public List<UserAuthResponseDto> findAll() {
        List<UserAuthEntity> users =  userAuthRepo.findAll();
        List<UserAuthResponseDto> dtoList = new ArrayList<>();

        for (UserAuthEntity user : users) {
            UserAuthResponseDto resDto = modelMapper.map(user,UserAuthResponseDto.class);
            dtoList.add(resDto);
        }
        return dtoList;
    }

    @Override
    public UserAuthResponseDto getById(Long id) {
        UserAuthEntity user = userAuthRepo.findById(id).get();
        UserAuthResponseDto response =modelMapper.map(user, UserAuthResponseDto.class);
        return response;
    }


}
