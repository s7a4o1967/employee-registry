package com.example.service.impl;

import com.example.dto.LoginDto;
import com.example.entity.LoginEntity;
import com.example.exception.UnauthourizedException;
import com.example.repository.LoginRepository;
import com.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginRepository loginrepository;
    @Override
    public boolean login(LoginDto loginDto) throws UnauthourizedException {
        LoginEntity loginEntity=loginrepository.findByEmpIdAndPassword(loginDto.getEmpId(),loginDto.getPassword());
        if(loginEntity==null) {
            throw new UnauthourizedException("Invalid Username or Password");
        }

        return true;
    }
}
