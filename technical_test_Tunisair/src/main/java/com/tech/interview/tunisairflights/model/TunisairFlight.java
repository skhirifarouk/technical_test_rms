package com.tech.interview.tunisairflights.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tech.interview.tunisairflights.util.validator.country.ValidCountryCode;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity : flight entries
 */
@Entity
@Table(name = "Tunisair_flight")
public class TunisairFlight {
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
    private String airline;

    /**
     * Price
     */
    private double price;

    /**
     * Cabin class
     */
    private String cabinclass;
    @Column(length = 3)

    /**
     * Departure airport : ISO country code
     */
    @ValidCountryCode
    private String departureAirportCode;

    /**
     * Destination airport : ISO country code
     */
    @ValidCountryCode
    @Column(length = 3)
    private String destinationAirportCode;

    /**
     * Departure date
     */
    private Date departureDate;

    /**
     * Arrival date
     */
    private Date arrivalDate;

    public TunisairFlight() {
    }

    public TunisairFlight(String airline, double price, String cabinclass, String departureAirportCode, String destinationAirportCode, Date departureDate, Date arrivalDate) {
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

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
