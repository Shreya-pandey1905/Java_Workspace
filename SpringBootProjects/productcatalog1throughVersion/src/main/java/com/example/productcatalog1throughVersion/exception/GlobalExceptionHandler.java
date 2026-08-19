package com.example.productcatalog1throughVersion.exception;

import com.example.productcatalog1throughVersion.entity.Products;
import com.example.productcatalog1throughVersion.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    Map<String, String> error= new HashMap<>();

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleExce(ResourceNotFoundException ex)
    {
        ApiResponse<Object> response  = ApiResponse.builder().success(false).msg(ex.getMessage()).data(null).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleValidations (MethodArgumentNotValidException exceptions){

        exceptions.getBindingResult().getFieldErrors().
                forEach(errors->error.put(errors.getField(),errors.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
       // return new ResponseEntity<>.status(HttpStatus.BAD_REQUEST);

    }

}
