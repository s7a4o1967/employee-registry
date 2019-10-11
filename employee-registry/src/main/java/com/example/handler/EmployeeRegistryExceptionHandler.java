package com.example.handler;

import com.example.controller.LoginController;
import com.example.exception.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(basePackageClasses = LoginController.class)
@RestController
public class EmployeeRegistryExceptionHandler {
    @ExceptionHandler({UnauthorizedException.class})
    ResponseEntity<Object> handleUnauthorizedException(UnauthorizedException unauthorizedException){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(unauthorizedException.getMessage());
    }
}