package com.Ak.CompanyManagement.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name =  "company_details")
public class Company {

    @Id
    private  final String name = "AK_TECH_STUDIO";
    private  String founder;
    private  final  String establishedYear = "2025";
    private  String location;
    private  String about ;


}
