package com.tech.interview.nouvelairflights.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

/**
 * ResourceNotFoundException: 404
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception implements Serializable {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
