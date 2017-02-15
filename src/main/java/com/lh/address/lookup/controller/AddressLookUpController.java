package com.lh.address.lookup.controller;

import com.lh.address.lookup.domain.Address;
import com.lh.address.lookup.service.OpenUkAddressSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

//    @RequestMapping(value = "StreetNameByPostCode", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public String search(@RequestParam("postCode") String postCode) {
//        SearchCriteria criteria = toSearchCriteria(request);
//        List<Flight> flights = searchService.getFlights(criteria);
//        return flights;
//    }

    @RequestMapping(value = "addressesByPostCode", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Address> search(@RequestParam("postCode") String postCode) {
        return searchService.getAddressesByPostCode(postCode);
    }
}
