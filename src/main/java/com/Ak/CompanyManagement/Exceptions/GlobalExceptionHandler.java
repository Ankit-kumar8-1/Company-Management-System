package com.Ak.CompanyManagement.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InValidUpdateFieldException.class)
    public ResponseEntity<String> handlerInvalidException(InValidUpdateFieldException ex){
        return  new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<String> handleMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
        return new ResponseEntity<>("you can only perform GET or Put Method.",HttpStatus.METHOD_NOT_ALLOWED);
    }
}
