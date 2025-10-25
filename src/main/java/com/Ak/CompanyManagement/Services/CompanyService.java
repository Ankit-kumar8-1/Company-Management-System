package com.Ak.employeemanagement.Services;

import com.Ak.employeemanagement.Entity.Company;
import com.Ak.employeemanagement.Exceptions.InValidUpdateFieldException;
import com.Ak.employeemanagement.Repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class CompanyService {

    private CompanyRepository companyRepository;

    private CompanyService(CompanyRepository companyRepository){
        this.companyRepository=companyRepository;
    }


//    Get details
    public Company getCompanyDetail(){
        return  companyRepository.findById("AK_TECH_STUDIO").orElseThrow(()-> new RuntimeException("Company not found"));
    }


//    updates details
    public  Company updateCompanyDetail(Map<String ,String > updates){

        List<String > allowKey =  new ArrayList<>(Arrays.asList("founder","location","about"));
        for(String key : updates.keySet()){
            if(!allowKey.contains(key)){
                throw new InValidUpdateFieldException("You can only update: founder, location, about");
            }
        }

        Company company = getCompanyDetail();
        updates.forEach((key,value)->{
            if(value == null || value.isBlank()){
                throw  new InValidUpdateFieldException(key + " cannot be empty");
            }

            switch (key){
                case "founder" -> company.setFounder(value);
                case "location" -> company.setLocation(value);
                case "about"   -> company.setAbout(value);
            }
        });

        return  companyRepository.save(company);
    }

}
