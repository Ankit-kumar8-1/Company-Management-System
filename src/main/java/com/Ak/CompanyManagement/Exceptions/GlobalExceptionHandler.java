package com.Ak.CompanyManagement.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InValidUpdateFieldException.class)
    public ResponseEntity<String> handlerInvalidException(InValidUpdateFieldException ex){
        return  new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<String> handleMethodNotSupported(HttpRequestMethodNotSupportedException ex, WebRequest request) {
        String path = ((ServletWebRequest) request).getRequest().getRequestURI();
        System.out.println("🚨 Method Not Supported Handler Triggered for path: " + path);
        String controllerName;
        String allowed;

        if (path.matches(".*/company/?$")) {
            controllerName = "Company";
            allowed = "GET, PUT";

        } else if (path.matches(".*/department/?$")) {
            controllerName = "Department";
            allowed = "GET, POST";

        } else if (path.matches(".*/department/\\d+/?$")) {
            controllerName = "Department";
            allowed = "GET, PUT, DELETE";

        } else {
            controllerName = "This resource";
            String[] allowedMethods = ex.getSupportedMethods();
            allowed = allowedMethods != null ? String.join(", ", allowedMethods) : "Unknown";
        }

        String message = controllerName + " allows only these methods: " + allowed;
        return new ResponseEntity<>(message, HttpStatus.METHOD_NOT_ALLOWED);
    }


}
