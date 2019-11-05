package com.example.controller;

import com.example.dto.CredentialsDto;
import com.example.dto.PageDto;
import com.example.dto.RegisterDto;
import com.example.service.RegisterService;
import com.example.exception.CustomException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.logging.Logger;

@RestController
public class RegisterController {
    private final static Logger LOGGER = Logger.getLogger(RegisterController.class.getName());

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
   // @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Object> register(@RequestBody RegisterDto registerDto) throws CustomException, IOException {
        if (registerService.register(registerDto)) {
            String baseUrl = "http://email-service:8001/email";
            OkHttpClient client = new OkHttpClient();
            CredentialsDto credentialsDto = new CredentialsDto();
            credentialsDto.setEmail(registerDto.getEmail());
            credentialsDto.setEmpId(registerDto.getEmpId());
            credentialsDto.setFirstName(registerDto.getFirstName());
            credentialsDto.setPassword("password");
            com.squareup.okhttp.RequestBody requestBody = com.squareup.okhttp.RequestBody.create(MediaType.parse(org.springframework.http.MediaType.APPLICATION_JSON_VALUE), objectMapper.writeValueAsString(credentialsDto));
            Request request = new Request.Builder()
                    .url("http://email-service:8001/email")
                    .post(requestBody)
                    .build();
            Response response = client.newCall(request).execute();
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
        }
        else {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("");
        }
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Object> edit(@RequestBody RegisterDto registerDto) throws CustomException {

        return ResponseEntity.status(200).body(registerService.edit(registerDto));
    }

    @RequestMapping(value = "/details", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Object> details(@RequestBody PageDto pageDto) throws CustomException {
        return ResponseEntity.status(200).body(registerService.getDetails(pageDto));
    }

    @RequestMapping(value = "/view/{empId}", method = RequestMethod.GET)
    public ResponseEntity<Object> view(@PathVariable String empId) throws CustomException {
        return ResponseEntity.status(200).body(registerService.getProfile(empId));
    }

    @RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> search(@PathVariable String id) throws CustomException {
        LOGGER.info("validating user : " + id);
        return ResponseEntity.status(200).body(registerService.getValues(id));
    }

    @RequestMapping(value = "/delete/{empId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable String empId) throws CustomException {
        return ResponseEntity.status(200).body(registerService.deleteID(empId));
    }
}