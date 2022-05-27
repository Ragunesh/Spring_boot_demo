package com.ragunesh.Springboot.tutorial.repository;

import com.ragunesh.Springboot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface  DepartmentRepository extends JpaRepository<Department,Long> {

    public Department findByDepartmentName(String departmentName);
//    @Query("?1 -->jpql query")
//    @Query(value="",nativeQuery=true -->SQL query)
    public Department findByDepartmentNameIgnoreCase(String departmentName);
}
