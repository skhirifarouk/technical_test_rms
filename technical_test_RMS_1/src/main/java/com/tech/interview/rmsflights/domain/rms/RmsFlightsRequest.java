package com.tech.interview.rmsflights.domain.rms;

import com.tech.interview.rmsflights.enums.DateFormat;
import com.tech.interview.rmsflights.util.validator.country.ValidCountryCode;
import com.tech.interview.rmsflights.util.validator.date.ValidDateFormat;

import javax.validation.constraints.Max;

public class RmsFlightsRequest {

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
     * Passenger count : Maximum value 4
     */
    @Max(value = 4, message = "Maximum passenger count = 4")
    private int numberOfPassengers;


    /**
     * No args constrcutor
     */
    public RmsFlightsRequest() {
    }

    /**
     * All args constrcutor
     *
     * @param origin
     * @param destination
     * @param departureDate
     * @param returnDate
     * @param numberOfPassengers
     */
    public RmsFlightsRequest(String origin, String destination, String departureDate, String returnDate, int numberOfPassengers) {
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.numberOfPassengers = numberOfPassengers;
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

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(final int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
}
