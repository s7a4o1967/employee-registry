package com.example.repository;

import java.util.List;
import java.util.Optional;
import javax.persistence.OneToMany;
import com.example.entity.RegisterEntity;
import com.example.exception.CustomException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterEntity,String> {

    RegisterEntity findByEmpId(String empId);
    List<RegisterEntity> findByCreatedBy(String createdBy);

    @Query(value = "select e from RegisterEntity e where e.empId like %:id% OR e.firstName like %:id% OR e.lastName like %:id%")
    List<RegisterEntity> findByEmpIdLike(@Param("id") String id);
    boolean removeByEmpId(String empId);
}
