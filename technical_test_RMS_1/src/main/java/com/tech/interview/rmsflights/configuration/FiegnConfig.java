package com.tech.interview.rmsflights.configuration;

import com.tech.interview.rmsflights.exception.decoder.RMSErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feign configuration
 */
@Configuration
public class FiegnConfig {
    /**
     * Error decoder
     * @return
     */
    @Bean
    public ErrorDecoder errorDecoder() {
        return new RMSErrorDecoder();
    }
}
