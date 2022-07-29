package com.tech.interview.tunisairflights.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * ExceptionHandler
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    /**
     * Handler URL not found : 404
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), Arrays.asList(ex.getMessage()), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    /**
     * Validation exception handler : 400
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity<?> bindExcpetionHandler(BindException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getBindingResult().getAllErrors().stream().map(x-> x.getDefaultMessage()).collect(Collectors.toList()), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    /**
     * Validation exception handler : 400
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidExcpetionHandler(MethodArgumentNotValidException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getBindingResult().getAllErrors().stream().map(x-> x.getDefaultMessage()).collect(Collectors.toList()), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    /**
     * Other exceptions : 500
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExcpetionHandler(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), Arrays.asList(ex.getMessage()), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
