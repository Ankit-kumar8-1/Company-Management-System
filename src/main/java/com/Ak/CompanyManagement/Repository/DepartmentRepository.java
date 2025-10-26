package com.Ak.CompanyManagement.Repository;

import com.Ak.CompanyManagement.Entity.CompanyDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<CompanyDepartment,Integer> {

}
