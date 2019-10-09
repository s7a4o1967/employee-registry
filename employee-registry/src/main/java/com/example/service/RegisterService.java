package com.example.service;

import com.example.dto.RegisterDto;
import com.example.entity.RegisterEntity;
import com.example.exception.UnauthourizedException;
import org.springframework.stereotype.Service;

@Service
public interface RegisterService {
    boolean register(RegisterEntity registerEntity);
}
