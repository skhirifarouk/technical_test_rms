package com.tech.interview.rmsflights.exception.decoder;

import com.tech.interview.rmsflights.exception.BadRequestException;
import com.tech.interview.rmsflights.exception.ResourceNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.commons.lang3.StringUtils;

/**
 * Error decoder : Returns exceptions from http responses
 */
public class RMSErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            // Bad request
            case 400:
                return new BadRequestException(StringUtils.join(response.status(), " : Bad request"));
            // URL no found
            case 404:
                return new ResourceNotFoundException(StringUtils.join(response.status(), " : Url not found"));
            // Other exceptions
            default:
                return errorDecoder.decode(methodKey, response);
        }
    }
}

