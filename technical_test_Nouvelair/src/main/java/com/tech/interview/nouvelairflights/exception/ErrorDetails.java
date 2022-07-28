package com.tech.interview.nouvelairflights.exception;

import java.util.Date;
import java.util.List;

/**
 * Wrapped error entity
 */
public class ErrorDetails {
    /**
     * Date
     */
    private Date timestamp;

    /**
     * Message list
     */
    private List<String> messages;

    /**
     * Details
     */
    private String details;

    public ErrorDetails(Date timestamp, List<String> message, String details) {
        super();
        this.timestamp = timestamp;
        this.messages = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public List<String> getMessage() {
        return messages;
    }

    public String getDetails() {
        return details;
    }
}
