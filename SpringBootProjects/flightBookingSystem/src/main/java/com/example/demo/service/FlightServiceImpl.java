package com.example.demo.service;

import com.example.demo.DTO.ReqDTO;
import com.example.demo.entities.Flights;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.FlightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService{

    @Autowired
    FlightsRepository flightsRepository;

    @Override
    public Flights BookFlight(ReqDTO tickets) {
            Flights flights =new Flights();
            flights.setFlightNo(tickets.getFlightNo());
            flights.setPassengerName(tickets.getPassengerName());
            flights.setTravelDate(tickets.getTravelDate());
            return flightsRepository.save(flights);
    }

    @Cacheable(value = "flights", key = "#id")
    @Override
    public Flights findById(Long id) {
        return  flightsRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Flight details not found"));
    }

    @Override
    public List<Flights> findAll() {
        return flightsRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
         flightsRepository.deleteById(id);
    }

    @CachePut(value = "flights", key = "#id")
    @Override
    public Flights updateTicketDetails(Long id,ReqDTO tickets) {
        Flights flights =findById(id);
        flights.setFlightNo(tickets.getFlightNo());
        flights.setPassengerName(tickets.getPassengerName());
        flights.setTravelDate(tickets.getTravelDate());
        return flightsRepository.save(flights);
    }


}
