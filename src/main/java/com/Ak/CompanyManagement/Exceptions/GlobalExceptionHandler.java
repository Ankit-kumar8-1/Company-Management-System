package com.Ak.CompanyManagement.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InValidUpdateFieldException.class)
    public ResponseEntity<String> handlerInvalidException(InValidUpdateFieldException ex){
        return  new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<String> handleMethodNotSupported(HttpRequestMethodNotSupportedException ex, WebRequest request) {
        String path = ((ServletWebRequest)request).getRequest().getRequestURI(); // /company or /department
        String controllerName;

        if(path.contains("company")) {
            controllerName = "Company";
        } else if(path.contains("department")) {
            controllerName = "Department";
        } else {
            controllerName = "This resource";
        }

        String[] allowedMethods = ex.getSupportedMethods();
        String allowed = String.join(", ", allowedMethods);

        String message = controllerName + " allows only these methods: " + allowed;
        return new ResponseEntity<>(message, HttpStatus.METHOD_NOT_ALLOWED);
    }
}
