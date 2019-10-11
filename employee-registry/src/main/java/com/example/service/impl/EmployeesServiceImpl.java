package com.example.service.impl;

import com.example.entity.EmployeesEntity;
import com.example.exception.UserNotFoundException;
import com.example.repository.EmployeesRepository;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeesServiceImpl implements EmployeeService {

    @Autowired
    EmployeesRepository employeesRepository;



    public Optional<EmployeesEntity> getProfile(String empId) throws UserNotFoundException {

        Optional<EmployeesEntity> employeesEntity= employeesRepository.findById(empId);
        if(!(employeesEntity.isPresent())){
            throw new UserNotFoundException("User Not Found");
        }
        return employeesEntity;
    }



    public List<EmployeesEntity> getDetails(String createdBy) throws UserNotFoundException {
        List<EmployeesEntity> employeesEntity=employeesRepository.findByCreatedBy(createdBy);
        if(employeesEntity.size()==0){
            throw new UserNotFoundException("Users Not Found");
        }
        return employeesEntity;
    }


}
