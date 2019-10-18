package com.example.service.impl;

import java.awt.print.Pageable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
//import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.example.controller.RegisterController;
import com.example.dto.RegisterDto;
import com.example.entity.LoginEntity;
import com.example.entity.RegisterEntity;
import com.example.exception.CustomException;
import com.example.repository.RegisterRepository;
import com.example.repository.LoginRepository;
import com.example.service.RegisterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;


@Service
public class RegisterServiceImpl implements RegisterService{
    private final static Logger LOGGER= Logger.getLogger(RegisterServiceImpl.class.getName());

    @Autowired
    private RegisterRepository registerRepository;
    @Autowired
    private LoginRepository loginRepository;
    private RegisterEntity registerEntity;
    private ModelMapper modelMapper=new ModelMapper();

    @Override
    public boolean register(RegisterDto registerDto) throws CustomException {
        RegisterEntity registerEntity=null;
        RegisterEntity registerentity=null;
        LoginEntity loginEntity2=null;
        RegisterEntity registerEntity1=registerRepository.findByEmpId(registerDto.getEmpId());
        if(registerEntity1!=null){


            throw new CustomException("User already exists",HttpStatus.CONFLICT);
        }
        else{

            registerEntity=modelMapper.map(registerDto,RegisterEntity.class);
            LoginEntity loginEntity1=modelMapper.map(registerDto,LoginEntity.class);
            LocalDateTime localDateTime=LocalDateTime.now();
            registerEntity.setModifiedTime(localDateTime);
            loginEntity1.setCreatedTime(localDateTime);
            registerEntity.setPassword("password");
            loginEntity1.setPassword("password");
            registerentity = registerRepository.save(registerEntity);
            loginEntity2=loginRepository.save(loginEntity1);
        }
        return true;
    }

    @Override
    public boolean edit(RegisterDto registerDto) throws CustomException {
        LocalDateTime localDateTime=LocalDateTime.now();
        RegisterEntity registerEntity2=null;
        registerEntity2=registerRepository.findByEmpId(registerDto.getEmpId());


        if(registerEntity2==null){
            throw new CustomException("This ID does not exist",HttpStatus.BAD_REQUEST);
        }
        registerEntity=modelMapper.map(registerDto,RegisterEntity.class);
        registerEntity.setModifiedTime(localDateTime);
        registerEntity2=registerEntity;


        RegisterEntity registerEntity3=registerRepository.save(registerEntity2);
        return true;


    }
    public Optional<RegisterEntity> getProfile(String empId) throws CustomException {

        Optional<RegisterEntity> registerEntity= registerRepository.findById(empId);
        if(!(registerEntity.isPresent())){
            throw new CustomException("User Not Found",HttpStatus.BAD_REQUEST);
        }
        return registerEntity;
    }



    public Page<RegisterEntity> getDetails(String createdBy,int pageNo) throws CustomException {
        org.springframework.data.domain.Pageable pageable= PageRequest.of(pageNo,5, Sort.by("empId"));
        Page<RegisterEntity> employeesEntity= (Page<RegisterEntity>) registerRepository.findByCreatedBy(createdBy,pageable);
        if(employeesEntity==null){

            throw new CustomException("Users Not Found",HttpStatus.NO_CONTENT);
        }
        return employeesEntity;
    }

    @Override
    public List<RegisterEntity> getValues(String id) throws CustomException{
        LOGGER.info("validating user : "+id);

        return registerRepository.findByEmpIdLike(id);

    }
    @Transactional
    @Override
    public boolean deleteID(String empId) throws CustomException{
        registerEntity=registerRepository.findByEmpId(empId);
        if(registerEntity==null){
            throw new CustomException("User not Found",HttpStatus.BAD_REQUEST);
        }
        if(registerRepository.removeByEmpId(empId)!=0){
            return true;
        }
        return false;

    }




}