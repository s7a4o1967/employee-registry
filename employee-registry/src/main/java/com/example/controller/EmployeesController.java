package com.example.controller;


import com.example.exception.UnauthorizedException;
import com.example.exception.UserNotFoundException;
import com.example.service.EmployeeService;
import com.example.service.impl.EmployeesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeesController {

    @Autowired
    EmployeesServiceImpl employeesServiceImpl;

    @RequestMapping("/details/{createdBy}")
    public ResponseEntity<Object> details(@PathVariable String createdBy) throws UserNotFoundException{
        return ResponseEntity.status(200).body(employeesServiceImpl.getDetails(createdBy));
    }

    @RequestMapping(value="/view/{empId}")
    public ResponseEntity<Object> view(@PathVariable String empId) throws UserNotFoundException{
        return ResponseEntity.status(200).body(employeesServiceImpl.getProfile(empId));
    }


}
