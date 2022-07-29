package com.tech.interview.rmsflights.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

/**
 * BadRequestException: 400
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends Exception implements Serializable {

    public BadRequestException(String message) {
        super(message);
    }
}

