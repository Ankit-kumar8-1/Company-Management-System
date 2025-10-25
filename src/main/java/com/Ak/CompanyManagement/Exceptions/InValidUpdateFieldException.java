package com.Ak.employeemanagement.Exceptions;

public class InValidUpdateFieldException extends  RuntimeException{
    public  InValidUpdateFieldException (String messege){
        super(messege);
    }
}
