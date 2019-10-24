package com.example.handler;

import com.example.controller.LoginController;
import com.example.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(basePackageClasses = LoginController.class)
@RestController
public class EmployeeRegistryExceptionHandler {
    @ExceptionHandler({CustomException.class})
    ResponseEntity<Object> handleUnauthorizedException(CustomException unauthorizedException){
        return ResponseEntity.status(unauthorizedException.getStatus()).body(unauthorizedException.getMessage());
    }
}
