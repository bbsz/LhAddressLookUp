package com.lh.address.lookup.service.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by sergej on 15.2.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NameDto {
    @JsonProperty(value = "en", required = true)
    private String[] en;
    @JsonProperty(value = "cy", required = true)
    private String[] cy;

    public NameDto() {
    }

    public NameDto(String[] en) {
        this.en = en;
    }

    public String[] getEn() {
        return en;
    }

    public String[] getCy() {
        return cy;
    }

    public void setEn(String[] en) {
        this.en = en;
    }

    public void setCy(String[] cy) {
        this.cy = cy;
    }

    public String getFirstEn() {
        if (en.length > 0) {
            return en[0];
        }
        return null;
    }
}
