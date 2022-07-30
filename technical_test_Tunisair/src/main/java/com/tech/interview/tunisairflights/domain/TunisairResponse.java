package com.tech.interview.tunisairflights.domain;

import com.tech.interview.tunisairflights.enums.DateFormat;
import com.tech.interview.tunisairflights.util.validator.country.ValidCountryCode;
import com.tech.interview.tunisairflights.util.validator.date.ValidDateFormat;

import javax.validation.constraints.Pattern;

/**
 * Response
 */
public class TunisairResponse {

    /**
     * Airline company
     */
    private String airline;

    /**
     * Price
     */
    private double price;

    /**
     * Cabin class
     */
    @Pattern(regexp = "E|B", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Invalid cabin class")
    private String cabinclass;

    /**
     * Departure airport code : ISO country code
     */
    @ValidCountryCode
    private String departureAirportCode;

    /**
     * Destination airport code : ISO country code
     */
    @ValidCountryCode
    private String destinationAirportCode;

    /**
     * Departure date : ISO_LOCAL_DATE_TIME format
     */
    @ValidDateFormat(requireddateformat = DateFormat.ISO_LOCAL_DATE_TIME)
    private String departureDate;

    /**
     * Arrival date : ISO_LOCAL_DATE_TIME format
     */
    @ValidDateFormat(requireddateformat = DateFormat.ISO_LOCAL_DATE_TIME)
    private String arrivalDate;

    /**
     * No args constructor
     */
    public TunisairResponse() {
    }

    /**
     * All args constructor
     *
     * @param airline
     * @param price
     * @param cabinclass
     * @param departureAirportCode
     * @param destinationAirportCode
     * @param departureDate
     * @param arrivalDate
     */
    public TunisairResponse(String airline, double price, String cabinclass, String departureAirportCode, String destinationAirportCode, String departureDate, String arrivalDate) {
        this.airline = airline;
        this.price = price;
        this.cabinclass = cabinclass;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(final String airline) {
        this.airline = airline;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public String getCabinclass() {
        return cabinclass;
    }

    public void setCabinclass(final String cabinclass) {
        this.cabinclass = cabinclass;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(final String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(final String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(final String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(final String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

}
