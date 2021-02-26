package com.thoughtworks.capability.gtb.restfulapidesign.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResult> handle(ResponseStatusException ex) {
        ErrorResult errorResult = new ErrorResult(ex.getReason());
        return ResponseEntity.status(ex.getStatus()).body(errorResult);
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity<ErrorResult> handle(IndexOutOfBoundsException ex) {
        ErrorResult errorResult = new ErrorResult("groupID can't find !!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResult);

    }
}
