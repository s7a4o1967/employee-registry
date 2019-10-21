package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.dto.PageDto;
import com.example.dto.RegisterDto;
import com.example.entity.RegisterEntity;
import com.example.exception.CustomException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface RegisterService {
    boolean register(RegisterDto registerDto) throws CustomException;
    boolean edit(RegisterDto registerEntity) throws CustomException;
    boolean deleteID(String empId) throws CustomException;
    List<RegisterEntity> getValues(String id) throws CustomException;;

    Optional<RegisterEntity> getProfile(String empId) throws CustomException;
    Page<RegisterEntity> getDetails(PageDto pageDto) throws CustomException;
//    List<RegisterEntity> getValues(String id) throws CustomException;

}
