package com.lh.address.lookup.service.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by sergej on 15.2.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TownDto {
    @JsonProperty(value = "name")
    private NameDto name;

    public TownDto() {
    }

    public TownDto(NameDto name) {
        this.name = name;
    }

    public NameDto getName() {
        return name;
    }

    public void setName(NameDto name) {
        this.name = name;
    }

    public String getEnName() {
        return name.getFirstEn();
    }
}
