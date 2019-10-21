package com.example.controller;
import com.example.dto.PageDto;
import com.example.dto.RegisterDto;
import com.example.entity.RegisterEntity;
import com.example.service.RegisterService;
import com.example.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class RegisterController {
    private final static Logger LOGGER=Logger.getLogger(RegisterController.class.getName());

    @Autowired
    private RegisterService registerService;

    @RequestMapping(value="/register",method=RequestMethod.POST ,consumes = "application/json")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Object> register(@RequestBody RegisterDto registerDto) throws CustomException {
        return ResponseEntity.status(200).body(registerService.register(registerDto));
    }
    @RequestMapping(value="/edit",method=RequestMethod.POST,consumes="application/json")
    public ResponseEntity<Object> edit(@RequestBody RegisterDto registerDto) throws CustomException {

        return ResponseEntity.status(200).body(registerService.edit(registerDto));
    }

    @RequestMapping(value="/details",method=RequestMethod.POST,consumes = "application/json")
    public ResponseEntity<Object> details(@RequestBody PageDto pageDto) throws CustomException{
        return ResponseEntity.status(200).body(registerService.getDetails(pageDto));
    }

    @RequestMapping(value="/view/{empId}",method=RequestMethod.GET)
    public ResponseEntity<Object> view(@PathVariable String empId) throws CustomException{
        return ResponseEntity.status(200).body(registerService.getProfile(empId));
    }

    @RequestMapping(value="/search/{id}",method=RequestMethod.GET)
    public ResponseEntity<Object> search(@PathVariable String id) throws CustomException{
        LOGGER.info("validating user : "+id);
        return ResponseEntity.status(200).body(registerService.getValues(id));
    }
    @RequestMapping(value="/delete/{empId}",method=RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable String empId) throws CustomException{
        return ResponseEntity.status(200).body(registerService.deleteID(empId));
    }
}
