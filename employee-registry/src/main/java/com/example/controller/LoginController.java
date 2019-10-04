package com.example.controller;

import com.example.dto.LoginDto;
import com.example.exception.UnauthourizedException;
import com.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

@RestController
public class LoginController {
    private final static Logger LOGGER=Logger.getLogger(LoginController.class.getName());


    @Autowired
    private LoginService loginService;
    @RequestMapping(value="/login",method=RequestMethod.POST,consumes = "application/json",produces ="text/plain")
    public ResponseEntity<Object> login(@RequestBody LoginDto loginDto) throws UnauthourizedException {
        LOGGER.info("validating user : "+loginDto.getEmpId());
        return ResponseEntity.status(200).body(loginService.login(loginDto));
    }

}
