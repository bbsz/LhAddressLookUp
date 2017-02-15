package com.lh.address.lookup.service;

import com.google.common.annotations.VisibleForTesting;
import com.lh.address.lookup.domain.Address;
import com.lh.address.lookup.service.rest.dto.AddressDto;
import com.lh.address.lookup.service.rest.dto.OpenUkAddressSearchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
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
        OpenUkAddressSearchDto dto = restTemplate.getForObject(openAddressSearchByPostCodeUrl, OpenUkAddressSearchDto.class);
        return Arrays.stream(dto.getAddresses()).map(addressDto -> toAddress(addressDto)).collect(Collectors.toList());
    }

    private Address toAddress(AddressDto dto) {
        Address address = new Address();
        return address;
    }
}
