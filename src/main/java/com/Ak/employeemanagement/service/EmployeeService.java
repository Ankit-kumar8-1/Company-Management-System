package com.Ak.employeemanagement.service;

import com.Ak.employeemanagement.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee  saveEmployee( Employee employee);

    List<Employee>  getAllEmployee();

    Optional<Employee> getEmployeeById(Long id);

    Employee updateEmployee (Employee employee);

    void deleteEmployee(Long id);
}
