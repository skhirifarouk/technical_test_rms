package com.tech.interview.nouvelairflights.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tech.interview.nouvelairflights.util.validator.country.ValidCountryCode;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity : flight entries
 */
@Entity
@Table(name = "Nouvelair_flight")
public class NouvelairFlight {
    /**
     * Identifer
     */
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

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

    @Column(length = 3)

    /**
     * Departure airport : ISO country code
     */
    @ValidCountryCode
    private String departureAirportName;

    /**
     * Destination airport : ISO country code
     */
    @ValidCountryCode
    @Column(length = 3)
    private String destinationAirportName;

    /**
     * Departure date
     */
    private Date outboundDateTime;

    /**
     * Arrival date
     */
    private Date inboundDateTime;

    /**
     * Number of adults
     */
    private int numberOfAdults;

    public NouvelairFlight() {
    }

    public NouvelairFlight(String carrier, double basePrice, double tax, double discount, String departureAirportName, String destinationAirportName, Date outboundDateTime, Date inboundDateTime, int numberOfAdults) {
        this.carrier = carrier;
        this.basePrice = basePrice;
        this.tax = tax;
        this.discount = discount;
        this.departureAirportName = departureAirportName;
        this.destinationAirportName = destinationAirportName;
        this.outboundDateTime = outboundDateTime;
        this.inboundDateTime = inboundDateTime;
        this.numberOfAdults = numberOfAdults;
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

    public Date getOutboundDateTime() {
        return outboundDateTime;
    }

    public void setOutboundDateTime(Date outboundDateTime) {
        this.outboundDateTime = outboundDateTime;
    }

    public Date getInboundDateTime() {
        return inboundDateTime;
    }

    public void setInboundDateTime(Date inboundDateTime) {
        this.inboundDateTime = inboundDateTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }
}
