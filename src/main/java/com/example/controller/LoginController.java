package com.example.controller;

import com.example.dto.LoginDto;
import com.example.entity.LoginEntity;
import com.example.exception.CustomException;
import com.example.jwtconfig.JwtTokenUtil;
import com.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Logger;

@RestController
public class LoginController {
    private final static Logger LOGGER=Logger.getLogger(LoginController.class.getName());
    @Autowired
    private LoginService loginService;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @RequestMapping(value= "/authenticate",method = RequestMethod.POST,consumes = "application/json")
    public String authenticate(@RequestBody LoginDto loginDto) throws Exception{
        final LoginEntity loginDetails = loginService
                .findByEmpId(loginDto.getEmpId());
        if(loginDetails==null){
            return "No User Found";
        }
        else {
            final String token = jwtTokenUtil.generateToken(loginDetails);
            return token;
        }
    }
    @RequestMapping(value="/login",method=RequestMethod.POST,consumes = "application/json")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Object> login(@RequestBody LoginDto loginDto) throws CustomException {
        LOGGER.info("validating user : "+loginDto.getEmpId());
        return ResponseEntity.status(200).body(loginService.login(loginDto));
    }
}
