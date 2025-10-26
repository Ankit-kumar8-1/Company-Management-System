package com.Ak.CompanyManagement.Services;

import com.Ak.CompanyManagement.Entity.Company;
import com.Ak.CompanyManagement.Entity.Department;
import com.Ak.CompanyManagement.Repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DepartmentService {

    private  final DepartmentRepository departmentRepository;

    public  DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }


    public List<Department> getAllDepartment(){
        return  departmentRepository.findAll();
    }


    public Department getDepartmentbyid(int id){
        return departmentRepository.findById(id).orElseThrow(()-> new RuntimeException("Department not found with id: " + id));
    }

    public  Department updateDepartment(int id ,Map<String,String> updated ){
        Department deptupdate = departmentRepository.findById(id).orElseThrow(()-> new RuntimeException("Department not found with id : " + id));

        updated.forEach((key, value)->{
                switch (key){
                    case "department" : deptupdate.setDeptName(value);
                    case "manager" :deptupdate.setManager(value);
                    case "description" : deptupdate.setDescription(value);
                }

        });

        return  departmentRepository.save(deptupdate);
    }

    public void DeleteDeparment(int id){
        Department dep = departmentRepository.findById(id).orElseThrow(()->
                new RuntimeException("Department not found with id: "  + id));
        System.out.println(dep.getDeptName() + " Department (id: " + id + ") is removed");

        departmentRepository.delete(dep);

    }
}