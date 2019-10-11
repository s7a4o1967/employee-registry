package com.example.repository;

import com.example.entity.EmployeesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeesRepository extends JpaRepository<EmployeesEntity,String> {

    List<EmployeesEntity> findByCreatedBy(String createdBy);
}
