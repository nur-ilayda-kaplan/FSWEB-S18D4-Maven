package com.workintech.s18d1.exceptions;


import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {


    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    private ResponseEntity<BurgerErrorResponse> handleException(BurgerException exception) {
        log.error("burger exception occured! Exception details: ", exception);
        BurgerErrorResponse burgerErrorResponse = new BurgerErrorResponse(exception.getMessage());
        return new ResponseEntity<> (burgerErrorResponse, (HttpStatusCode) exception.getHttpStatus());
    }

    @ExceptionHandler
    private ResponseEntity<BurgerErrorResponse> handleException(Exception exception) {
        log.error("exception occured! Exception details: ", exception);
        BurgerErrorResponse burgerErrorResponse = new BurgerErrorResponse(exception.getMessage());
        return new ResponseEntity<>(burgerErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
