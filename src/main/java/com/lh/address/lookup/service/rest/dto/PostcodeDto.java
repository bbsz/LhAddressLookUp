package com.lh.address.lookup.service.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by sergej on 15.2.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostcodeDto {
    @JsonProperty(value = "name")
    private String name;

    public PostcodeDto() {
    }

    public PostcodeDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
