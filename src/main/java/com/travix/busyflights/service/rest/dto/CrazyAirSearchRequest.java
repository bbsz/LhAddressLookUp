package com.travix.busyflights.service.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by sergej on 13.2.2017.
 */
public class CrazyAirSearchRequest {

    @JsonProperty(value = "origin", required = true)
    private String origin;

    @JsonProperty(value = "destination", required = true)
    private String destination;

    @JsonProperty(value = "numberOfPassengers", required = true)
    private Integer numberOfPassengers;

    @JsonFormat(pattern = "MM-dd-yyyy")
    @JsonProperty(value = "departureDate", required = true)
    private Date departureDate;

    @JsonFormat(pattern = "MM-dd-yyyy")
    @JsonProperty(value = "returnDate", required = true)
    private Date returnDate;

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

    public Integer getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(Integer passengersCount) {
        this.numberOfPassengers = passengersCount;
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

    @Override
    public String toString() {
        return "CrazyAirSearchRequest{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", numberOfPassengers=" + numberOfPassengers +
                ", departureDate=" + departureDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
