package com.example.controller;
import com.example.dto.RegisterDto;
import com.example.service.LoginService;
import com.example.service.RegisterService;

import com.example.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    private LoginService loginService;

    @RequestMapping(value="/register",method=RequestMethod.POST ,consumes = "application/json")
    public ResponseEntity<Object> register(@RequestBody RegisterDto registerDto) throws CustomException {
        return ResponseEntity.status(200).body(registerService.register(registerDto));
    }
}
