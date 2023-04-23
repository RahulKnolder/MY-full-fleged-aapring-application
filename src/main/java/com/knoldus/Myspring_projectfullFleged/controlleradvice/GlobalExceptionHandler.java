package com.knoldus.Myspring_projectfullFleged.controlleradvice;

import org.apache.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleEmptyInput( ResourceNotFoundException resourceNotFoundException){
        return new ResponseEntity<>("enput fields are empty", HttpStatusCode.valueOf(HttpStatus.SC_GATEWAY_TIMEOUT));
    }

    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<String> handleNoDataInDb(ProductNotFound noSuchElementException){
        return new ResponseEntity<>("data is not present in db", HttpStatusCode.valueOf(HttpStatus.SC_NOT_FOUND));
    }

}
