package com.tech.interview.nouvelairflights.domain;

import com.tech.interview.nouvelairflights.enums.DateFormat;
import com.tech.interview.nouvelairflights.util.validator.country.ValidCountryCode;
import com.tech.interview.nouvelairflights.util.validator.date.ValidDateFormat;

/**
 * Response
 */
public class NouvelairResponse {

    /**
     * Airline company
     */
    private String carrier;

    /**
     * Base price
     */
    private double basePrice;

    /**
     * Tax
     */
    private double tax;

    /**
     * Discount
     */
    private double discount;

    /**
     * Departure airport name : ISO country code
     */
    @ValidCountryCode
    private String departureAirportName;

    /**
     * Destination airport name : ISO country code
     */
    @ValidCountryCode
    private String destinationAirportName;

    /**
     * Departure date : ISO_LOCAL_DATE_TIME format
     */
    @ValidDateFormat(requireddateformat = DateFormat.ISO_LOCAL_DATE_TIME)
    private String outboundDateTime;

    /**
     * Arrival date : ISO_LOCAL_DATE_TIME format
     */
    @ValidDateFormat(requireddateformat = DateFormat.ISO_LOCAL_DATE_TIME)
    private String inboundDateTime;

    public NouvelairResponse() {
    }

    public NouvelairResponse(String carrier, double basePrice, double tax, double discount, String departureAirportName, String destinationAirportName, String outboundDateTime, String inboundDateTime) {
        this.carrier = carrier;
        this.basePrice = basePrice;
        this.tax = tax;
        this.discount = discount;
        this.departureAirportName = departureAirportName;
        this.destinationAirportName = destinationAirportName;
        this.outboundDateTime = outboundDateTime;
        this.inboundDateTime = inboundDateTime;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(final String carrier) {
        this.carrier = carrier;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(final double basePrice) {
        this.basePrice = basePrice;
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }

    public void setDepartureAirportName(final String departureAirportName) {
        this.departureAirportName = departureAirportName;
    }

    public String getDestinationAirportName() {
        return destinationAirportName;
    }

    public void setDestinationAirportName(final String destinationAirportName) {
        this.destinationAirportName = destinationAirportName;
    }

    public String getOutboundDateTime() {
        return outboundDateTime;
    }

    public void setOutboundDateTime(final String outboundDateTime) {
        this.outboundDateTime = outboundDateTime;
    }

    public String getInboundDateTime() {
        return inboundDateTime;
    }

    public void setInboundDateTime(final String inboundDateTime) {
        this.inboundDateTime = inboundDateTime;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
