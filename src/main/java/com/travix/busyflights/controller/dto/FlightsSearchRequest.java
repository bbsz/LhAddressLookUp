package com.travix.busyflights.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by sergej on 13.2.2017.
 */
public class FlightsSearchRequest {
    @NotNull
    @Length(max = 3, min = 3, message = "Origin must be 3 letter IATA code")
    @JsonProperty(value = "origin", required = true)
    private String origin;

    @NotNull
    @Length(max = 3, min = 3, message = "Destination must be 3 letter IATA code")
    @JsonProperty(value = "destination", required = true)
    private String destination;

    @NotNull(message = "numberOfPassengers has to be specified.")
    @Range(min = 1, max = 4, message = "numberOfPassengers not in valid range")
    @JsonProperty(value = "numberOfPassengers", required = true)
    private Integer numberOfPassengers;

    @NotNull
    @Future
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    @JsonProperty(value = "departureDate", required = true)
    private Date departureDate;

    @NotNull
    @Future
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
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
}
