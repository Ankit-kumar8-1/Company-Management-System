package com.Ak.CompanyManagement.Controller;

import com.Ak.CompanyManagement.Entity.Company;
import com.Ak.CompanyManagement.Services.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/company")
public class CompanyController {

    private final  CompanyService companyService;

    public  CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }

    @GetMapping
    public Company getcompanydetail(){
        return companyService.getCompanyDetail();
    }

    @PutMapping
    public  Company updatescompanydetail(@RequestBody Map<String,String> updates){
        return companyService.updateCompanyDetail(updates);
    }


}
