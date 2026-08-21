package com.example.demo.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ReqDTO {


    @NotBlank(message = "Flight number is required")
    private String flightNo;

    @NotBlank(message = "Passenger name is required")
    private String passengerName;

    @NotNull(message = "Date should not be null")
    private Date travelDate;


}
