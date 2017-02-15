package com.lh.address.lookup.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by sergej on 15.2.2017.
 */
public class Address {

    private static final String STREET_ADDRESS_SEPARATOR = " ";

    @JsonProperty(value = "houseNumber", required = true)
    private String houseNumber;
    @JsonProperty(value = "street", required = true)
    private String street;
    @JsonProperty(value = "town", required = true)
    private String town;
    @JsonProperty(value = "postCode", required = true)
    private String postCode;

    public Address() {
    }

    public Address(String houseNumber, String street, String town, String postCode) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.town = town;
        this.postCode = postCode;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getStreetAddress() {
        return houseNumber + STREET_ADDRESS_SEPARATOR + street;
    }
}
