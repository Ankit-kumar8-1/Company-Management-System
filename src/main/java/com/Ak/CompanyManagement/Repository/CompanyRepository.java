package com.Ak.employeemanagement.Repository;

import com.Ak.employeemanagement.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository  extends   JpaRepository<Company,String>{
}
