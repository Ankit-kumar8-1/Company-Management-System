package com.Ak.CompanyManagement.Services;

import com.Ak.CompanyManagement.Entity.Company;
import com.Ak.CompanyManagement.Entity.Department;
import com.Ak.CompanyManagement.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
                    case "department_Name" : deptupdate.setDepartment_Name(value);
                    case "manager" :deptupdate.setManager(value);
                    case "description" : deptupdate.setDescription(value);
                }

        });

        return  departmentRepository.save(deptupdate);
    }

    public Department addDepartment(Map<String,String> newDepartment){
        List<String> allField = List.of("department_Name","manager","description");

        for (String str : newDepartment.keySet()){
            if(!allField.contains(str)){
                throw new RuntimeException("You can only add these fields: deptName, manager, description");
            }
        }

        Department department = new Department();

        if(newDepartment.containsKey("department_Name")){
            department.setDepartment_Name(newDepartment.get("department_Name"));
        }
        if(newDepartment.containsKey("manager")){
            department.setManager(newDepartment.get("manager"));
        }
        if(newDepartment.containsKey("description")){
            department.setDescription(newDepartment.get("description"));
        }

        Department saveddept = departmentRepository.save(department);
        System.out.println("New Department is added in Department Section");
        return saveddept;

    }

    public void DeleteDeparment(int id){
        Department dep = departmentRepository.findById(id).orElseThrow(()->
                new RuntimeException("Department not found with id: "  + id));
        System.out.println(dep.getDepartment_Name() + " Department (id: " + id + ") is removed");

        departmentRepository.delete(dep);

    }
}