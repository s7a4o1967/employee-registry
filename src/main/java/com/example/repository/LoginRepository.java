package com.example.repository;

import com.example.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity,String>{
    LoginEntity findByEmpId(String empId);
    LoginEntity findByEmpIdAndPassword(String empId,String password);


}
