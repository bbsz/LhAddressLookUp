package com.travix.busyflights.service.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by sergej on 13.2.2017.
 */
public class ToughJetSearchRequest {

    @JsonProperty(value = "from", required = true)
    private String origin;

    @JsonProperty(value = "to", required = true)
    private String destination;

    @JsonProperty(value = "numberOfAdults", required = true)
    private Integer numberOfPassengers;

    @JsonProperty(value = "departureDay", required = true)
    private Integer departureDay;

    @JsonProperty(value = "departureMonth", required = true)
    private Integer departureMonth;

    @JsonProperty(value = "departureYear", required = true)
    private Integer departureYear;

    @JsonProperty(value = "returnDay", required = true)
    private Integer returnDay;

    @JsonProperty(value = "returnMonth", required = true)
    private Integer returnMonth;

    @JsonProperty(value = "returnYear", required = true)
    private Integer returnYear;

    public ToughJetSearchRequest() {
    }

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

    public Integer getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(Integer departureDay) {
        this.departureDay = departureDay;
    }

    public Integer getDepartureMonth() {
        return departureMonth;
    }

    public void setDepartureMonth(Integer departureMonth) {
        this.departureMonth = departureMonth;
    }

    public Integer getDepartureYear() {
        return departureYear;
    }

    public void setDepartureYear(Integer departureYear) {
        this.departureYear = departureYear;
    }

    public Integer getReturnDay() {
        return returnDay;
    }

    public void setReturnDay(Integer returnDay) {
        this.returnDay = returnDay;
    }

    public Integer getReturnMonth() {
        return returnMonth;
    }

    public void setReturnMonth(Integer returnMonth) {
        this.returnMonth = returnMonth;
    }

    public Integer getReturnYear() {
        return returnYear;
    }

    public void setReturnYear(Integer returnYear) {
        this.returnYear = returnYear;
    }

    public void setDepartureDate(Date date) {
        departureYear = getYear(date);
        departureMonth = getMonth(date);
        departureDay = getDay(date);
    }

    public void setReturnDate(Date date) {
        returnYear = getYear(date);
        returnMonth = getMonth(date);
        returnDay = getDay(date);
    }

    private int getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    private int getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }

    private int getDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public String toString() {
        return "ToughJetSearchRequest{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", numberOfPassengers=" + numberOfPassengers +
                ", departureDay=" + departureDay +
                ", departureMonth=" + departureMonth +
                ", departureYear=" + departureYear +
                ", returnDay=" + returnDay +
                ", returnMonth=" + returnMonth +
                ", returnYear=" + returnYear +
                '}';
    }
}
