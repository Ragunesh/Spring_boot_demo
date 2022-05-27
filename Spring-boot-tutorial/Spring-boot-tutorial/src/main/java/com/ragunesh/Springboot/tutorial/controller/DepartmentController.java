package com.ragunesh.Springboot.tutorial.controller;

import com.ragunesh.Springboot.tutorial.entity.Department;
import com.ragunesh.Springboot.tutorial.error.DepartmentNotFoundException;
import com.ragunesh.Springboot.tutorial.service.DepartmentService;
import com.ragunesh.Springboot.tutorial.service.DepartmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
//        DepartmentService service = new DepartmentServiceImpl(); --> resolve it with dependency injection
        logger.info("Inside saveDepartment() of DepartmentController");

        return departmentService.saveDepartment(department);
    }
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        logger.info("Inside fetchDepartmentList() of DepartmentController");
        return departmentService.fetchDepartmentList();
    }
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {


        return departmentService.fetchDepartmentById(departmentId);
    }
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable ("id") Long departmentId){
        departmentService. deleteDepartmentById(departmentId);

        return "Department is deleted successfully";
    }
    @PutMapping("/departments/{id}")
    public Department updateDepartmentById(@PathVariable("id")Long departmentId,@RequestBody Department department){
        return departmentService.updateDepartmentById(departmentId,department);
    }
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);

    }

}
