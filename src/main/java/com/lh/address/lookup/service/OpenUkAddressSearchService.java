package com.lh.address.lookup.service;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import com.lh.address.lookup.domain.Address;
import com.lh.address.lookup.service.rest.dto.OpenUkAddressDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by sergej on 13.2.2017.
 */
@Service
public class OpenUkAddressSearchService {

    private RestTemplate restTemplate;
    private String openAddressSearchByPostCodeUrl;

    @Autowired
    public OpenUkAddressSearchService(@Value("${openUkAddressSearch.byPostCode}") String openUkAddressSearchUrl) {
        this.openAddressSearchByPostCodeUrl = openUkAddressSearchUrl;
        this.restTemplate = new RestTemplate();
    }

    @VisibleForTesting
    OpenUkAddressSearchService(RestTemplate restTemplate, String openAddressSearchByPostCodeUrl) {
        this.restTemplate = restTemplate;
        this.openAddressSearchByPostCodeUrl = openAddressSearchByPostCodeUrl;
    }

    public List<Address> getAddressesByPostCode(String postCode) {
        Map<String, String> params = new HashMap<>();
        params.put("postCode", postCode);
        OpenUkAddressDto[] dtos = restTemplate.getForObject(openAddressSearchByPostCodeUrl, OpenUkAddressDto[].class, params);
        return Arrays.stream(dtos).map(dto -> toAddress(dto)).collect(Collectors.toList());
    }

    private Address toAddress(OpenUkAddressDto dto) {
        Address flight = new Address();
        return flight;
    }
}
