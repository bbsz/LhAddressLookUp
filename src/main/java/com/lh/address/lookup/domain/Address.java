package com.lh.address.lookup.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by sergej on 15.2.2017.
 */
public class Address {

    @JsonProperty(value = "houseNumber", required = true)
    private String houseNumber;
    @JsonProperty(value = "street", required = true)
    private String street;
    @JsonProperty(value = "city", required = true)
    private String city;
    @JsonProperty(value = "postCode", required = true)
    private String postCode;

    public Address() {
    }

    public Address(String houseNumber, String street, String city, String postCode) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
