package com.example.ecommerce.Advice;

import com.example.ecommerce.DTOs.ExceptionResponseDto;
import com.example.ecommerce.Exceptions.ProductNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<ExceptionResponseDto> handelProductNotFoundException(){
      ExceptionResponseDto response = new ExceptionResponseDto();
      response.setMessage("Product Not Found");
      response.setStatus(HttpStatus.NOT_FOUND);
      return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
