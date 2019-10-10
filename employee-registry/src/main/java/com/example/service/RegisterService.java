package com.example.service;

import com.example.dto.RegisterDto;
import com.example.exception.CustomException;
import org.springframework.stereotype.Service;

@Service
public interface RegisterService {
    boolean register(RegisterDto registerDto) throws CustomException;
}
