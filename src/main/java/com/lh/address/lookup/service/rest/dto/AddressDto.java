package com.lh.address.lookup.service.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by sergej on 13.2.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDto {
    @JsonProperty(value = "pao")
    private String pao;
    @JsonProperty(value = "street")
    private StreetDto street;
    @JsonProperty(value = "town")
    private TownDto town;
    @JsonProperty(value = "postcode")
    private PostcodeDto postcode;


    public String getPao() {
        return pao;
    }

    public StreetDto getStreet() {
        return street;
    }

    public TownDto getTown() {
        return town;
    }

    public PostcodeDto getPostcode() {
        return postcode;
    }

    public void setPao(String pao) {
        this.pao = pao;
    }

    public void setStreet(StreetDto street) {
        this.street = street;
    }

    public void setTown(TownDto town) {
        this.town = town;
    }

    public void setPostcode(PostcodeDto postcode) {
        this.postcode = postcode;
    }
}
