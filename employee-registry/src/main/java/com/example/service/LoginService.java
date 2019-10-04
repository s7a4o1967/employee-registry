package com.example.service;

import com.example.dto.LoginDto;
import com.example.exception.UnauthourizedException;
import org.springframework.stereotype.Service;

@Service
public interface LoginService  {
    boolean login(LoginDto loginDto) throws UnauthourizedException;
}
