package com.lh.address.lookup.controller;

import com.lh.address.lookup.domain.Address;
import com.lh.address.lookup.service.OpenUkAddressSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergej on 15.2.2017.
 */
@RestController
@RequestMapping("addressLookUp/")
public class AddressLookUpController {
    private OpenUkAddressSearchService searchService;

    @Autowired
    public AddressLookUpController(OpenUkAddressSearchService searchService) {
        this.searchService = searchService;
    }

    @RequestMapping(value = "streetNamesByPostCode", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> searchStreetNamesByPostCode(@RequestParam("postCode") String postCode) {
        List<Address> addresses = searchAddressesByPostCode(postCode);
        return getStreetNames(addresses);
    }

    @RequestMapping(value = "addressesByPostCode", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Address> searchAddressesByPostCode(@RequestParam("postCode") String postCode) {
        return searchService.getAddressesByPostCode(postCode);
    }

    private List<String> getStreetNames(List<Address> addresses) {
        List<String> streetNames = new ArrayList<>();
        for (Address address : addresses) {
            String streetName = address.getStreet().trim();
            if (!streetNames.contains(streetName)) {
                streetNames.add(streetName);
            }
        }
        return streetNames;
    }
}
