package com.travix.busyflights.service.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by sergej on 13.2.2017.
 */
public class ToughJetFlightDto {

    @JsonProperty(value = "carrier", required = true)
    private String airLine;

    @JsonProperty(value = "basePrice", required = true)
    private double basePrice;

    @JsonProperty(value = "tax", required = true)
    private double tax;

    @JsonProperty(value = "price", required = true)
    private double discount;

    @JsonProperty(value = "departureAirportName", required = true)
    private String departureAirportCode;

    @JsonProperty(value = "arrivalAirportName", required = true)
    private String destinationAirportCode;

    @JsonProperty(value = "departureDay", required = true)
    private int departureDay;

    @JsonProperty(value = "departureMonth", required = true)
    private int departureMonth;

    @JsonProperty(value = "departureYear", required = true)
    private int departureYear;

    @JsonProperty(value = "returnDay", required = true)
    private int returnDay;

    @JsonProperty(value = "returnMonth", required = true)
    private int returnMonth;

    @JsonProperty(value = "returnYear", required = true)
    private int returnYear;

    @JsonIgnore
    private Date departureDate;

    @JsonIgnore
    private Date returnDate;

    public ToughJetFlightDto() {
    }

    public String getAirLine() {
        return airLine;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getTax() {
        return tax;
    }

    public double getDiscount() {
        return discount;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public int getDepartureDay() {
        return departureDay;
    }

    public int getDepartureMonth() {
        return departureMonth;
    }

    public int getDepartureYear() {
        return departureYear;
    }

    public int getReturnDay() {
        return returnDay;
    }

    public int getReturnMonth() {
        return returnMonth;
    }

    public int getReturnYear() {
        return returnYear;
    }

    public Date getDepartureDate() {
        return toDate(departureYear, departureMonth, departureDay);
    }

    public Date getReturnDate() {
        return toDate(returnYear, returnMonth, returnDay);
    }

    public Double getPrice(){
        return getBasePrice() + getTax() - getDiscount();
    }

    private Date toDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month - 1, day);
        return cal.getTime();
    }

    @Override
    public String toString() {
        return "ToughJetFlightDto{" +
                "airLine='" + airLine + '\'' +
                ", basePrice=" + basePrice +
                ", tax=" + tax +
                ", discount=" + discount +
                ", departureAirportCode='" + departureAirportCode + '\'' +
                ", destinationAirportCode='" + destinationAirportCode + '\'' +
                ", departureDay=" + departureDay +
                ", departureMonth=" + departureMonth +
                ", departureYear=" + departureYear +
                ", returnDay=" + returnDay +
                ", returnMonth=" + returnMonth +
                ", returnYear=" + returnYear +
                ", departureDate=" + departureDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
