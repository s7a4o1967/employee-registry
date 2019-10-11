package com.example.service;

import com.example.dto.EmployeeDto;
import com.example.entity.EmployeesEntity;
import com.example.exception.UserNotFoundException;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public Optional<EmployeesEntity> getProfile(String empId) throws UserNotFoundException;
    public List<EmployeesEntity> getDetails(String createdBy) throws UserNotFoundException;

}
