package com.example.service.impl;

import com.example.dto.LoginDto;
import com.example.entity.LoginEntity;
import com.example.exception.CustomException;
import com.example.repository.LoginRepository;
import com.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    LoginRepository loginrepository;

    @Override
    public boolean login(LoginDto loginDto) throws CustomException {
        LoginEntity loginEntity = loginrepository.findByEmpIdAndPassword(loginDto.getEmpId(), loginDto.getPassword());
        if (loginEntity == null) {
            throw new CustomException("Invalid Username or Password", HttpStatus.UNAUTHORIZED);
        }

        return true;
    }
}