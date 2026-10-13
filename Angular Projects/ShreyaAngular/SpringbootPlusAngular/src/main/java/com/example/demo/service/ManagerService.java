package com.example.demo.service;

import com.example.demo.dto.ManagerDto;
import com.example.demo.repo.ManagerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepo managerRepo;
    @Autowired
    ModelMapper mapper;
    public List<ManagerDto> getAllManagers() {
        return managerRepo.findAll()
                .stream()
                .map(m -> {
                    return mapper.map(m, ManagerDto.class);
                })
                .toList();
    }
}
