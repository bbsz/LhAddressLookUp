package com.travix.busyflights.service;

import java.util.Date;

/**
 * Created by sergej on 13.2.2017.
 */
public class SearchCriteria {
    private String origin;
    private String destination;
    private Date departureDate;
    private Date returnDate;
    private Integer numberOfPassengers;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getNumberOfPassengers() {
        return numberOfPassengers;
    }
    public void setNumberOfPassengers(Integer numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
}
