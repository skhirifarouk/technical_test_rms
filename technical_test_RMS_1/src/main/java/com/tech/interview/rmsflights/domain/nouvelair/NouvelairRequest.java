package com.tech.interview.rmsflights.domain.nouvelair;

import com.tech.interview.rmsflights.enums.DateFormat;
import com.tech.interview.rmsflights.util.validator.country.ValidCountryCode;
import com.tech.interview.rmsflights.util.validator.date.ValidDateFormat;

/**
 * Request object
 */
public class NouvelairRequest {

    /**
     * Origin : ISO country code
     */
    @ValidCountryCode
    private String from;

    /**
     * Destination: ISO contry code
     */
    @ValidCountryCode
    private String to;

    /**
     * Outbound date : ISO_LOCAL_DATE format
     */
    @ValidDateFormat(requireddateformat = DateFormat.ISO_LOCAL_DATE)
    private String outboundDate;

    /**
     * Inbound date : ISO_LOCAL_DATE format
     */
    @ValidDateFormat(requireddateformat = DateFormat.ISO_LOCAL_DATE)
    private String inboundDate;

    /**
     * Number of adults
     */
    private int numberOfAdults;

    /**
     * All args constructor
     *
     * @param from
     * @param to
     * @param outboundDate
     * @param inboundDate
     * @param numberOfAdults
     */
    public NouvelairRequest(String from, String to, String outboundDate, String inboundDate, int numberOfAdults) {
        this.from = from;
        this.to = to;
        this.outboundDate = outboundDate;
        this.inboundDate = inboundDate;
        this.numberOfAdults = numberOfAdults;
    }

    /**
     * No args constructor
     */
    public NouvelairRequest() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(final String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(final String to) {
        this.to = to;
    }

    public String getOutboundDate() {
        return outboundDate;
    }

    public void setOutboundDate(final String outboundDate) {
        this.outboundDate = outboundDate;
    }

    public String getInboundDate() {
        return inboundDate;
    }

    public void setInboundDate(final String inboundDate) {
        this.inboundDate = inboundDate;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(final int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }
}
