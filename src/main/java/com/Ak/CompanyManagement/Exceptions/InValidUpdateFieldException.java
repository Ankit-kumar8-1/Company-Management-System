package com.Ak.CompanyManagement.Exceptions;

public class InValidUpdateFieldException extends  RuntimeException{
    public  InValidUpdateFieldException (String messege){
        super(messege);
    }
}
