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
    @JsonProperty(value = "locality")
    private LocalityDto locality;
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

    public LocalityDto getLocality() {
        return locality;
    }

    public TownDto getTown() {
        return town;
    }

    public PostcodeDto getPostcode() {
        return postcode;
    }
}
