package com.example.repository;

import com.example.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<LoginEntity,String>{

    LoginEntity findByEmpIdAndPassword(String empId,String password);
}
