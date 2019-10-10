package com.example.repository;

import com.example.entity.LoginEntity;
import com.example.entity.RegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterEntity,String> {

    RegisterEntity findByEmpId(String empId);
}
