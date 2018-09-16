package com.aiwine.train.controller;

import com.aiwine.train.controller.response.ExceptionResponse;
import com.aiwine.train.exception.MyAccountNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AccountControllerHandler {

    @ExceptionHandler(MyAccountNotFoundException.class)
    public ResponseEntity<ExceptionResponse> accountNotFound(MyAccountNotFoundException exception) {
        ExceptionResponse response = new ExceptionResponse(exception.getMessage(), "More");

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
    }
}
