package com.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<?> handleNoResult(MethodArgumentNotValidException ex) {
        return new ResponseEntity(ErrorObject.builder()
            .code("007")
            .message("validation exception")
            .field("email")
            .build(), HttpStatus.BAD_REQUEST);
    }
}
