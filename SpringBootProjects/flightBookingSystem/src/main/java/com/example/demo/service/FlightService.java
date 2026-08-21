package com.example.demo.service;

import com.example.demo.DTO.ReqDTO;
import com.example.demo.entities.Flights;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FlightService {

    Flights BookFlight(ReqDTO tickets);

    Flights findById(Long id);

    List<Flights> findAll();

    void deleteById(Long id);

    Flights updateTicketDetails(Long id,ReqDTO tickets);
}