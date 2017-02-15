package com.lh.address.lookup.service.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by sergej on 13.2.2017.
 */
public class OpenUkAddressDto {
    @JsonProperty(value = "airline", required = true)
    private String airLine;

    @JsonProperty(value = "price", required = true)
    private double price;

    @JsonProperty(value = "cabinclass", required = true)
    private String cabinClass;

    @JsonProperty(value = "departureAirportCode", required = true)
    private String departureAirportCode;

    @JsonProperty(value = "destinationAirportCode", required = true)
    private String destinationAirportCode;

    @JsonFormat(pattern = "MM-dd-yyyy HH:mm:ss")
    @JsonProperty(value = "departureDate", required = true)
    private Date departureDate;

    @JsonFormat(pattern = "MM-dd-yyyy HH:mm:ss")
    @JsonProperty(value = "arrivalDate", required = true)
    private Date arrivalDate;


    public OpenUkAddressDto() {
    }

    public String getAirLine() {
        return airLine;
    }

    public double getPrice() {
        return price;
    }

    public String getCabinClass() {
        return cabinClass;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    @Override
    public String toString() {
        return "OpenUkAddressDto{" +
                "airLine='" + airLine + '\'' +
                ", price=" + price +
                ", cabinClass='" + cabinClass + '\'' +
                ", departureAirportCode='" + departureAirportCode + '\'' +
                ", destinationAirportCode='" + destinationAirportCode + '\'' +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                '}';
    }
}
