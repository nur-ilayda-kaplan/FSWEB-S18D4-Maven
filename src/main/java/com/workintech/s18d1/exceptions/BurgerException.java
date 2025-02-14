package com.workintech.s18d1.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class BurgerException extends RuntimeException{
    private HttpStatus httpStatus;

    public BurgerException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public BurgerException(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public BurgerException(String message, int scNotFound) {
    }

    public Object getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(Object httpStatus) {
        this.httpStatus = (HttpStatus) httpStatus;
    }
}
