package com.example.repository;

import com.example.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginTableFRepository extends JpaRepository<LoginEntity,String> {

}
