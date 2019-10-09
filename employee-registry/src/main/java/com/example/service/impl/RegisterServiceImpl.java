package com.example.service.impl;

import com.example.dto.RegisterDto;
import com.example.entity.RegisterEntity;
import com.example.repository.RegisterRepository;
import com.example.service.RegisterService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService{
    @Autowired
    RegisterRepository registerRepository;
    private ModelMapper modelMapper;
    private RegisterEntity registerEntity;


    @Override
    public boolean register(RegisterEntity registerEntity) {
        this.registerEntity = registerEntity;
        RegisterEntity registerentity=null;
        //RegisterEntity registerEntity=modelMapper.map(registerDto,RegisterEntity.class);
        registerentity = registerRepository.save(registerEntity);
        if(registerEntity==null){
            return false;
        }
        return true;
    }
}
//egisterDto.getAge(),registerDto.getCreatedBy(),registerDto.getCreatedTime(),registerDto.getEmail(),registerDto.getEmpId(),registerDto.getGender(),registerDto.getFirstName(),registerDto.getLastName()