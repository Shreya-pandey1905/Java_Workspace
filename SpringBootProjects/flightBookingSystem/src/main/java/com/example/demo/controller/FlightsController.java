package com.example.demo.controller;

import com.example.demo.DTO.ReqDTO;
import com.example.demo.entities.Flights;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.FlightServiceImpl;
import com.example.demo.service.IdempotencyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/flights")
public class FlightsController
{

    @Autowired
    FlightServiceImpl flightService;

    @Autowired
    IdempotencyService idempotencyService;


    @GetMapping("/findById/{id}")
    public ResponseEntity<ApiResponse<Flights>> findById(@PathVariable Long id){
        Flights flights=  flightService.findById(id);
        ApiResponse<Flights> apiRes = ApiResponse.<Flights>builder().success(true).msg("Data found").data(flights).build();
        return ResponseEntity.ok().body(apiRes);
    }


    @GetMapping("/findAll")
    public ResponseEntity<ApiResponse<List<Flights>>> findAll(){
         List<Flights> flights  = flightService.findAll();
         ApiResponse<List<Flights>> apiResponse = ApiResponse.<List<Flights>>builder().success(true)
                 .msg("Data found").data(flights).build();
        return ResponseEntity.ok().body(apiResponse);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<ApiResponse<Flights>> deleteById(@PathVariable Long id){
        flightService.deleteById(id);
        ApiResponse<Flights> apiResponse = ApiResponse.<Flights>builder().success(true)
                .msg("Data deleted").data(null).build();
        return ResponseEntity.ok().body(apiResponse);
    }



    @PostMapping("/bookTicket")
    public ResponseEntity<ApiResponse<Flights>> bookTickets(@RequestHeader("Idempotency-Key") String idempotencyKey,
                                                            @Valid @RequestBody ReqDTO request){

        if (idempotencyService.isProcessed(idempotencyKey)){
            Long existingFlightId = idempotencyService.getFlightsId(idempotencyKey);
            Flights existingBookedFlight= flightService.findById(existingFlightId);

            ApiResponse<Flights> response = ApiResponse.<Flights>builder()
                    .success(true)
                    .msg("Request already processed")
                    .data(existingBookedFlight).build();

            return ResponseEntity.status(HttpStatus.OK).body(response);


        }

        Flights flights = flightService.BookFlight(request);
        idempotencyService.save(idempotencyKey, flights.getId());
        ApiResponse<Flights> response = ApiResponse.<Flights>builder()
                .success(true)
                .msg("Flight tickets booked successfully")
                .data(flights).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @PutMapping("/updateFlightDetails/{id}")
    public ResponseEntity<ApiResponse<Flights>> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ReqDTO request) {

        Flights updatedFlightDetails = flightService.updateTicketDetails(id, request);
        ApiResponse<Flights> response =
                ApiResponse.<Flights>builder()
                        .success(true)
                        .msg("Flight details updated successfully")
                        .data(updatedFlightDetails)
                        .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }



}
