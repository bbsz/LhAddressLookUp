package com.lh.address.lookup.service.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by sergej on 15.2.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenUkAddressSearchDto {
    @JsonProperty("addresses")
    private AddressDto[] addresses;

    public AddressDto[] getAddresses() {
        return addresses;
    }
}
