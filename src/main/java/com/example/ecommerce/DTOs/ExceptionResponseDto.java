package com.example.ecommerce.DTOs;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Data
//@ControllerAdvice
public class ExceptionResponseDto {
    private String message;
    private HttpStatus status;
}
