package com.example.handler;


import com.example.controller.EmployeesController;
import com.example.controller.LoginController;
import com.example.exception.UnauthorizedException;
import com.example.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;


@ControllerAdvice(basePackageClasses = {EmployeesController.class})
@RestController
public class EmployeesExceptionHandler {

    private final static Logger LOGGER=Logger.getLogger(EmployeesExceptionHandler.class.getName());

    @ExceptionHandler({UserNotFoundException.class})
    ResponseEntity<Object> handleUnauthorizedException(UserNotFoundException userNotFoundException) {
        LOGGER.info("handling exeception : "+userNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(userNotFoundException.getMessage());
    }
}