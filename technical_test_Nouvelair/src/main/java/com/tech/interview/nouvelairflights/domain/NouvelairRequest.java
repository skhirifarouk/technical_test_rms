package com.tech.interview.nouvelairflights.domain;

import com.tech.interview.nouvelairflights.enums.DateFormat;
import com.tech.interview.nouvelairflights.util.validator.country.ValidCountryCode;
import com.tech.interview.nouvelairflights.util.validator.date.ValidDateFormat;

/**
 * Request object
 */
public class NouvelairRequest {

    /**
     * Origin : ISO country code
     */
    @ValidCountryCode
    private String origin;

    /**
     * Destination: ISO contry code
     */
    @ValidCountryCode
    private String destination;

    /**
     * Departure date : ISO_LOCAL_DATE format
     */
    @ValidDateFormat(requireddateformat = DateFormat.ISO_LOCAL_DATE)
    private String departureDate;

    /**
     * Arrival date : ISO_LOCAL_DATE format
     */
    @ValidDateFormat(requireddateformat = DateFormat.ISO_LOCAL_DATE)
    private String returnDate;

    /**
     * Passenger count
     */
    private int passengerCount;

    public NouvelairRequest(String origin, String destination, String departureDate, String returnDate) {
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
    }

    public NouvelairRequest(){

    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(final String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(final String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(final String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(final String returnDate) {
        this.returnDate = returnDate;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(final int passengerCount) {
        this.passengerCount = passengerCount;
    }
}
