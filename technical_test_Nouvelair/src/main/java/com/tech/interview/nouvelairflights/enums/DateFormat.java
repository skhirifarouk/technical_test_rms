package com.tech.interview.nouvelairflights.enums;

import java.time.format.DateTimeFormatter;

/**
 * Date format enum
 */
public enum DateFormat {
    ISO_LOCAL_DATE(DateTimeFormatter.ISO_LOCAL_DATE),
    ISO_LOCAL_DATE_TIME(DateTimeFormatter.ISO_LOCAL_DATE_TIME);


    DateTimeFormatter dateTimeFormatter;

    DateFormat(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }

    public DateTimeFormatter getDateTimeFormatter() {
        return dateTimeFormatter;
    }
}
