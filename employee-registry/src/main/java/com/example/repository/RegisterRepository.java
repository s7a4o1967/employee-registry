package com.example.repository;

import com.example.entity.RegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterEntity,String> {


//    RegisterEntity save(Date createdTime, String email, String empId, String gender, String firstName, String lastName, int age, String createdBy) ;
}
