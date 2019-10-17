package com.example.service;

import com.example.dto.LoginDto;
import com.example.exception.CustomException;
import org.springframework.stereotype.Service;

@Service
public interface LoginService  {
    boolean login(LoginDto loginDto) throws CustomException;
}