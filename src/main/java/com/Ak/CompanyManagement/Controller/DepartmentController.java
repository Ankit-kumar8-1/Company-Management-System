package com.Ak.CompanyManagement.Controller;

import com.Ak.CompanyManagement.Entity.Department;
import com.Ak.CompanyManagement.Services.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private  final DepartmentService departmentService;

    public  DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartment();
    }

    @GetMapping({"/{id}"})
    public Department getDepartmentById(@PathVariable int id){
        return departmentService.getDepartmentbyid(id);
    }

    @PutMapping({"/{id}"})
    public Department updateDepartment(@PathVariable int id, @RequestBody Map<String,String> updates){
        return departmentService.updateDepartment(id,updates);
    }

    @DeleteMapping({"/{id}"})
    public void  deleteDepartment(@PathVariable int id){
        departmentService.DeleteDeparment(id);
    }


    @PostMapping
    public Department addDepartment(@RequestBody Map<String,String> newdepartment){
        return departmentService.addDepartment(newdepartment);
    }

}
